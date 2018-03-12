//server.js
‘use strict’


var express = require(‘express’);
var mongoose = require(‘mongoose’);
var bodyParser = require(‘body-parser’);
//and create our instances


var mongoose = require(‘mongoose’);
var Schema = mongoose.Schema;


var CommentsSchema = new Schema({
 author: String,
 text: String
});


module.exports = mongoose.model(‘Comment’, CommentsSchema);


var app = express();
var router = express.Router();


var port = process.env.API_PORT || 3001;

app.use(bodyParser.urlencoded({ extended: true }));
app.use(bodyParser.json());
//To prevent errors from Cross Origin Resource Sharing, we will set 
//our headers to allow CORS with middleware like so:
//model/comments.js



app.use(function(req, res, next) {
 res.setHeader(‘Access-Control-Allow-Origin’, ‘*’);
 res.setHeader(‘Access-Control-Allow-Credentials’, ‘true’);
 res.setHeader(‘Access-Control-Allow-Methods’, ‘GET,HEAD,OPTIONS,POST,PUT,DELETE’);
 res.setHeader(‘Access-Control-Allow-Headers’, ‘Access-Control-Allow-Headers, Origin,Accept, X-Requested-With, Content-Type, Access-Control-Request-Method, Access-Control-Request-Headers’);
//and remove cacheing so we get the most recent comments


 res.setHeader(‘Cache-Control’, ‘no-cache’);
 next();
});




router.get(‘/’, function(req, res) {
 res.json({ message: ‘API Initialized!’});
});


app.use(‘/api’, router);


app.listen(port, function() {
 console.log(`api running on port ${port}`);
});