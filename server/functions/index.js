const functions = require('firebase-functions')
const express = require('express')
const admin = require('firebase-admin')
const morgan = require('morgan')
const bodyParser = require('body-parser')

admin.initializeApp({
    apiKey: "AIzaSyD1iC-e5p8h5eoL16v51bpMJfAxo5gAr68",
    authDomain: "blog-android-application.firebaseapp.com",
    databaseURL: "https://blog-android-application.firebaseio.com",
    projectId: "blog-android-application",
    storageBucket: "blog-android-application.appspot.com",
    messagingSenderId: "489144798988"
})

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

app.get('/blogs', (req, res) => {
    admin.firestore().getCollections('blogs').then((colData) => {
        return res.send(colData)
    })
})

app.post('/blogs/create', (req, res) => {
    const blog = req.body()
    res.send(blog)
})

app.get('/blogs/:key', (req, res) => {
    const key = req.params.key
    res.send(key)
})

app.delete('/blogs/:key', (req, res) => {
    const key = req.params.key
    res.send(key)
})

// API
exports.api = functions.https.onRequest(app)

// Test data
exports.helloWorld = functions.https.onRequest((request, response) => {
    response.send({
        message: "Hello from Firebase!"
    });
});

app.listen(8900, () => {
    console.log('Listening on port 8900');
})