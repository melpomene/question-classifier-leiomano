
Question classifier web interface
=================================
Takes a question for the game Kvitt eller Dubbelt and classify it to one of many categories. 

WARNING
-------
This is only intended as a local developing test enviroment. 
There are some really nasty injections that could be performed if this was run on a public server, so don't, unless you take the time to escape the input.

Requirements
------------
Needs [flask](http://flask.pocoo.org/) to run.

How to run
----------
    python webserver.py 

or add wsgi file and run through apache

Screenshot
---------

(UI borrowed from my master thesis)

![Question classifier](https://raw.github.com/melpomene/question-classifier-hajen/master/snapshot/screenshot.jpeg)
