const express = require('express'),
    path = require('path'),
    bodyParser = require('body-parser'),
    cors = require('cors'),

    const app = express();
    var port = process.env.PORT || 4000;

    app.get('/add', function (req, res) {
 
        res.send('ページが表示されました！');
     
    });

    var server = app.listen(function(){
        console.log('Listening on port ' + port);
    });