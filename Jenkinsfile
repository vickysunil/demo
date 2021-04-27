pipeline {
    agent any
    stages {
        stage('Verify Branch') {
            steps {
                echo "$GIT_BRANCH"
                sh(script: 'whoami')
                sh(script: 'id  ')
            }
        }
        stage('Docker Build') {
            steps {
                sh(script: 'docker images -a')
                sh(script: """
                    cd azure-vote/
                    docker images -a
                    docker build -t jenkins-pipeline .
                    docker images -a
                    cd ..
                """)
            }
        }
        stage('start test app')
        steps{
            sh(script: """
            docker compose up
            """)
        }
        post {
            success {
                echo "App started successfully"
            }
            failure {
                echo "App start failed"
            }
        }
        stage('Run Tests'){
            steps{
                sh(script:"""
                    pytest ./tests/test_sample.py
                """)
            }
        }
        stage('stop test app') {
            sh(script: """
            docker compose down
            """)
        }
        }
    }
