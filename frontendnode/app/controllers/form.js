const {validationResult} = require("express-validator");
const axios = require("axios");

exports.signup = (request, response, next) => {
    const errors = validationResult(request);
    const data = getErrorMessages(errors, request.session.data, 'name', 'sex', 'age', 'country');

    if (!data.valid) {
        console.log(JSON.stringify(data));
        response.render('/index', data);
    } else {
        axios.post('http://localhost:8080/user/register', data)
            .then(function (res) {
                response.render('/success', {name: data.name});
            })
            .catch(function (res) {
                console.log(res)
                response.status(422).redirect("/error")
            });
    }
}

function getErrorMessages (errors, sessionData, ...fields) {
    let valid = true;
    return fields.reduce((errorMessages, field) => {
        let fieldError = getErrorMessage(errors, field);
        if (fieldError) valid = false;
        if (fieldError) {
            fieldError = {text:fieldError}
        }
        return {
            ...errorMessages,
            valid,
            [`${field}ErrorMessage`]: fieldError,
            [field]: sessionData[field]
        };
    }, {});
}

function getErrorMessage (validationResult, field) {
    if (validationResult.errors) {
        let fieldError = validationResult.errors.find(error => error.path === field);
        if (fieldError) {
            return fieldError.msg;
        }
    }
    return null;
}
