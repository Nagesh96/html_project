def LOG_FILE = env.BUILD_LOG_ENV
def command = "grep '\\[INFO\\] Deploying artifact:' $LOG_FILE | awk '{print \$NF}'"
def url = sh(script: command, returnStdout: true).trim()
echo "Extracted URL: $url"
