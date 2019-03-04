const functions = require('firebase-functions')
const express = require('express')
const admin = require('firebase-admin')
const morgan = require('morgan')
const bodyParser = require('body-parser')

// Create express application
const app = express()

// Apply body parser
app.use(bodyParser.urlencoded({
    extended: false
}))

// Apply Morgan
app.use(morgan('combined'))

app.get('/', (req, res) => {
    res.send({
        message: 'You have just accessed the Blog official APIs!'
    })
})

// API
exports.app = functions.https.onRequest(app)

// Test data
exports.helloWorld = functions.https.onRequest((request, response) => {
    response.send({
        message: "Hello from Firebase!"
    });
});