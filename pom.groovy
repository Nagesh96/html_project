def pom = readMavenPom file: 'pom.xml'
def artifactId = pom.artifactId
def version = pom.version

echo "Artifact ID: ${artifactId}"
echo "Version: ${version}"
