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
                    sh "echo version=${version} | sed 's/-null//' "
                    echo "Artifact ID: ${ARTIFACT_ID}"
                    env.VERSION = version
                    env.ARTIFACT_ID = ARTIFACT_ID
                    def FIELD_ID = "customfield_17856" 
                    env.FIELD_ID = FIELD_ID
                    def JFROG_ARTIFACTURL = "https://jfrog.charter.com/ui/builds/mobile-backend-builds%20::%20qualitygates-mobilecicd%20::%20${JOB_BASE_NAME}/${BUILD_NUMBER}"
                    VALUE = ${ARTIFACT_ID}-${VERSION}-${BUILD_NUMBER}
                    env.VALUE = VALUE
                    def text = "Reference URL of the published Artifact: "
                    def link = "${JFROG_ARTIFACTURL}"
                    COMMENT = "${text}${link}"
                    env.COMMENT = COMMENT
        


def pom = readMavenPom file: 'pom.xml'
def ARTIFACT_ID = pom.artifactId
def version = pom.version.replaceAll(/-(\d+)-\$\{BUILD_NUMBER\}/, '-')
echo "Version: ${version}"
echo "Artifact ID: ${ARTIFACT_ID}"
env.VERSION = version

def pom = readMavenPom file: 'pom.xml'
def ARTIFACT_ID = pom.artifactId
def version = pom.version.replaceAll(/-(\d+)-\$\{BUILD_NUMBER\}.*/, '')
echo "Version: ${version}"
echo "Artifact ID: ${ARTIFACT_ID}"
env.VERSION = version




def FIELD_ID = "customfield_17856" 
env.FIELD_ID = FIELD_ID

def JFROG_ARTIFACTURL = "https://jfrog.charter.com/ui/builds/mobile-backend-builds%20::%20qualitygates-mobilecicd%20::%20${JOB_BASE_NAME}/${BUILD_NUMBER}"
env.JFROG_ARTIFACTURL = JFROG_ARTIFACTURL

def VALUE = "${ARTIFACT_ID}-${VERSION}-${BUILD_NUMBER}"
env.VALUE = VALUE

def text = "Reference URL of the published Artifact: "
def link = "${JFROG_ARTIFACTURL}"
def COMMENT = "${text}${link}"
env.COMMENT = COMMENT





def version = pom.version.replaceAll(/-(\d+)-\$\{BUILD_NUMBER\}/, '')



pipeline {
    agent any
    
    stages {
        stage('Extract Artifact Info') {
            steps {
                script {
                    def packageJson = readFile('path/to/package.json')
                    def json = readJSON text: packageJson
                    
                    def artifactId = json.name
                    def version = json.version
                    
                    echo "Artifact ID: ${artifactId}"
                    echo "Version: ${version}"
                    
                    // You can store these values in environment variables or use them as needed
                    // For example, to store in environment variables:
                    env.ARTIFACT_ID = artifactId
                    env.VERSION = version
                }
            }
        }
        
        // Add more stages for your build, test, deployment, etc.
    }
}







