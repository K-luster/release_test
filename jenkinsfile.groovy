pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/K-luster/release_test.git'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean install'
            }
        }

        stage('Docker Build') {
            steps {
                sh 'docker build -t your-docker-image:latest .'
            }
        }

        stage('Docker Push') {
            steps {
                withCredentials([usernamePassword(credentialsId: 'your-docker-credentials', usernameVariable: 'DOCKER_USERNAME', passwordVariable: 'DOCKER_PASSWORD')]) {
                    sh 'docker login -u $DOCKER_USERNAME -p $DOCKER_PASSWORD'
                    sh 'docker push your-docker-image:latest'
                }
            }
        }

        stage('Kubernetes Deploy') {
            environment {
                KUBECONFIG = credentials('your-kubeconfig-credentials')
            }
            steps {
                sh 'kubectl apply -f your-kubernetes-deployment.yaml'
            }
        }
    }
}