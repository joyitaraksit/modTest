//
// For guidance on how to create routes see:
// https://prototype-kit.service.gov.uk/docs/create-routes
//

const govukPrototypeKit = require('govuk-prototype-kit')
const router = govukPrototypeKit.requests.setupRouter()
const axios = require("axios");

const {check} = require('express-validator')
const formController = require('./controllers/form');

router.post('/index',
    check(['name', 'sex', 'age', 'country']).notEmpty().withMessage('Field cannot be empty'),
    formController.signup
);