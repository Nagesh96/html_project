        stage('Search Log File') {
            steps {
                script {
                    def logFilePath = '/var/lib/jenkins/workspace/addressbook/jenkins_console_output.txt'
                    def pattern = 'Deploying artifact: (http[s]?:\\/\\/(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}(?::\\d{1,5})?(?:\\/\\S*)?\\/(?:\\S+\\/)*\\S+\\.(?:jar|war))'

                    def grepCommand = "grep -E \"$pattern\" $logFilePath"
                    def grepOutput = sh(script: grepCommand, returnStdout: true).trim()

                    echo "Grep Output:\n$grepOutput"
                }
            }
        }


def pattern = 'http://54\\.211\\.105\\.217:8082/.*\\.(jar|war)'


post {
        always {
            script {
                def log = currentBuild.rawBuild.getLog()
                writeFile file: 'output.log', text: log
            }
        }
    }
