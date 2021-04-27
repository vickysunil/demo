pipeline {
    agent any
    environment {
        RELEASE = '20.04'
    }
    stages {
        stage('Build') {
            agent any
            environment {
                LOG_LEVEL='INFO'
            }
            steps {
                echo "Building release ${RELEASE} with log level ${LOG_LEVEL}..." 
            }
        }
        stage('Test') {
            steps {
                echo "Testing release ${RELEASE}..."
            }
        }
        stage('Deploy') {
            input {
                message 'Deploy?'
                OK 'Do it!'
                parameters {
                    string(name: 'TARGET_ENVIRONMENT', defaultValue: 'PROD', description: 'Target deployment environment')
                }
            }
        }
    }    
}