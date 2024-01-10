//
// For guidance on how to create routes see:
// https://prototype-kit.service.gov.uk/docs/create-routes
//

const govukPrototypeKit = require('govuk-prototype-kit')
const router = govukPrototypeKit.requests.setupRouter()
const axios = require("axios");

// Add your routes here
router.post('/index', function (request, response, next) {

    let name = request.session.data['name']
    let sex = request.session.data['sex']
    let age = request.session.data['age']
    let country = request.session.data['country']

    let valid = true;

    let nameErrorMessage = null;
    let sexErrorMessage = null;
    let ageErrorMessage = null;
    let countryErrorMessage = null;

    if(isInvalid(name)) {
        nameErrorMessage = {text: 'Please enter your name'}
        valid = false;
    }
    if(isInvalid(sex)) {
        sexErrorMessage = {text: 'Please enter your sex'}
        valid = false;
    }
    if(isInvalid(age)) {
        ageErrorMessage = {text: 'Please enter your age'}
        valid = false;
    }
    if(isInvalid(country)) {
        countryErrorMessage = {text: 'Please enter your country'}
        valid = false;
    }

    if (!valid) {
        let data = {
            nameErrorMessage,
            sexErrorMessage,
            ageErrorMessage,
            countryErrorMessage,
            name
        }

        response.render('/index', data);

    } else {

        let jsonObj = {name,sex,age,country}

        axios.post('http://localhost:8080/user/register', jsonObj)
            .then(function (res) {
                console.log(res);
                response.render('/success', {name});
            })
            .catch(function (res) {
                console.log(res);
                response.redirect("/error")
            });

    }
})

function isInvalid(field) {
    console.log(field)
    if(field===undefined || field.length===0) {
        return true;
    }
}