from flask import Flask, render_template, request
import commands
app = Flask(__name__)

@app.route("/")
def index():
    return render_template('/index.html')

@app.route("/classify", methods = ['POST'])
def classify():
    """ XXX: WARNING THIS METHOD HAVE SERIOUS XSS VULNERABILITIES. DO NOT RUN IN THE WILD """
    question = request.form['question']
    result = commands.getstatusoutput('java -jar classifier.jar "' + question +'"')
    return result[1]

if __name__ == "__main__":
    app.run()



