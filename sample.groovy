pipeline {
    agent any

    stages {
        stage('Search Log File') {
            steps {
                script {
                    def logFilePath = 'path/to/your/logfile.log'
                    def pattern = 'Deploying artifact: (http[s]?:\\/\\/(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}(?::\\d{1,5})?(?:\\/\\S*)?\\/(?:\\S+\\/)*\\S+\\.(?:jar|war))'

                    def grepCommand = "grep -E \"$pattern\" $logFilePath"
                    def grepOutput = sh(script: grepCommand, returnStdout: true).trim()

                    echo "Grep Output:\n$grepOutput"
                }
            }
        }
    }
}
