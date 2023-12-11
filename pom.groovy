def pom = readMavenPom file: 'pom.xml'
def artifactId = pom.artifactId
def version = pom.version

echo "Artifact ID: ${artifactId}"
echo "Version: ${version}"



pipeline {
    agent any

    parameters {
        gitParameter branchFilter: '.*', defaultValue: 'master', description: 'Select the branch', name: 'BRANCH'
    }

    stages {
        stage('Checkout') {
            steps {
                script {
                    // Retrieve the selected branch from the parameter
                    def selectedBranch = params.BRANCH ?: 'master'

                    // Checkout the selected branch
                    git branch: selectedBranch, url: 'https://github.com/your/repo.git'
                }
            }
        }
        // Other stages in your pipeline
    }
}


def pom = readMavenPom file: 'pom.xml'

def ARTIFACT_ID = pom.artifactId
def version = pom.version

sh "echo 'VERSION=${version != null ? version.replaceAll('-null', '') : ''}'"
