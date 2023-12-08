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


pipeline {
    agent any

    stages {
        stage('Fetch and Display Console Output') {
            steps {
                script {
                    // Fetch console output and save to a file
                    def output = sh(returnStdout: true, script: "curl -s ${BUILD_URL}/consoleText")
                    writeFile file: 'output.txt', text: output
                    
                    // Read the file and display the content in the console
                    def savedOutput = readFile('output.txt')
                    echo "Console Output:"
                    echo savedOutput
                }
            }
        }
    }
}



pipeline {
    agent any

    stages {
        stage('Fetch and Display Console Output') {
            steps {
                script {
                    def username = 'your_username'
                    def password = 'your_password'
                    
                    def output = sh(
                        returnStdout: true,
                        script: "curl -u ${username}:${password} -s ${BUILD_URL}/consoleText"
                    )
                    writeFile file: 'output.txt', text: output

                    def savedOutput = readFile('output.txt')
                    echo "Console Output:"
                    echo savedOutput
                }
            }
        }
    }
}
