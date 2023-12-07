pipeline {
    agent any
    
    stages {
        stage('Capture Artifact Name') {
            steps {
                script {
                    def log = currentBuild.rawBuild.getLog(1000) // Fetches last 1000 lines of the console log

                    def filePattern = /\/([^\/]+\.(jar|war))$/
                    def matchedFile = log =~ filePattern

                    if (matchedFile) {
                        echo "Artifact file name: ${matchedFile[0][1]}"
                        // Access matchedFile[0][1] for the captured file name (JAR or WAR)
                    }
                }
            }
        }
        // Other stages in your pipeline
    }
    // Post-build actions, etc.
}
