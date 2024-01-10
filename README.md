# Backend for REST API

## Run requirements
* Java 17
* Node 16
* Maven installation

## Run instructions
#### Backend
Navigate to folder *backend* and run from terminal
```bash
mvn install
```
to install dependencies and then to run project:
```bash
mvn spring-boot:run
```

#### Frontend
Navigate to folder *frontend*  and run from terminal
```bash
npm install
```

to install dependencies and then to run project:
```bash
npm run dev
```

### Improvements
* persist h2 to file
* environment variables for server ports and CORS
* more back end testing
* front end testing
* don't clear form in invalidation
* more thorough validation checks
* better server-side form validation flow
* middleware in express to handle java server call
* use prod gov uk package, not prototype
* column constraints on db
* radio component validation
* propagate HTTP status codes from backend to front end