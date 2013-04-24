from flask import Flask, render_template, request
import subprocess, shlex
app = Flask(__name__)

@app.route("/")
def index():
    return render_template('/index.html')

@app.route("/classify", methods = ['POST'])
def classify():
    """ XXX: WARNING THIS METHOD HAVE SERIOUS XSS VULNERABILITIES. DO NOT RUN IN THE WILD """
    question = request.form['question']
    args = [u'java', u'-jar', u'classifier.jar',u'"'+ question+ u'"']
    result = subprocess.check_output(args)
    print result
    return result
    return unicode(result.decode("utf-8")).encode("utf-8")

if __name__ == "__main__":
    app.debug = True
    app.run()



