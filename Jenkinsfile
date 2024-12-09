pipeline {
    agent any
    tools{
        maven 'Maven 3.9'
    }
    stages{
        stage('Build Maven'){
            steps{
                checkout([$class: 'GitSCM', branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/Haitam-Elgharras/BankAccount-microservice']]])
                sh 'mvn clean install'
            }
        }
        stage('Build docker image'){
            steps{
                script{
                    sh 'docker build -t bankAccountService-0.0.1-SNAPSHOT .'
                }
            }
        }
        stage('Push image to dockerhub'){
            steps{
                script{
                   withCredentials([string(credentialsId: 'dockerhub-pwd', variable: 'dockerhubpwd')]) {
                   sh 'docker login -u haitamelgharras -p ${dockerhubpwd}'

                   }
                   sh 'docker push haitamelgharras/bankAccountService-0.0.1-SNAPSHOT'
                }
            }
        }
    }
}