pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                sh 'echo "Building..."'
                // 빌드 단계에서 수행할 작업을 추가할 수 있습니다.
            }
        }

        stage('Test') {
            steps {
                sh 'echo "Testing..."'
                // 테스트 단계에서 수행할 작업을 추가할 수 있습니다.
            }
        }

        stage('Deploy') {
            steps {
                sh 'echo "Deploying..."'
                // 배포 단계에서 수행할 작업을 추가할 수 있습니다.
            }
        }
    }

    post {
        always {
            sh 'echo "Post-build: Always"'
            // 항상 수행되는 작업을 추가할 수 있습니다.
        }

        success {
            sh 'echo "Post-build: Success"'
            // 성공적으로 완료된 경우 수행되는 작업을 추가할 수 있습니다.
        }

        failure {
            sh 'echo "Post-build: Failure"'
            // 실패한 경우 수행되는 작업을 추가할 수 있습니다.
        }
    }
}