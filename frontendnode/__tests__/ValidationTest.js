const form = require('../app/controllers/form')

test('empty validation should return no error message', () => {

    expect(form.getErrorMessage({}, "age")).toBe(null);
});
