def consoleOutput = '[consumer_e] Deploying artifact: http://54.211.105.217:8082/artifactory/example-repo-local/addressbook.war'
def pattern = /http:\/\/[\d.:\/]+addressbook\.war/
def url = (consoleOutput =~ pattern).find { it }
if (url) {
    println "Found URL: ${url[0]}"
}
