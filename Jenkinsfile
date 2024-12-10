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
                    sh 'docker build -t bankaccountservice:latest .'
                }
            }
        }
        stage('Push image to dockerhub'){
            steps{
                script{
                   withCredentials([string(credentialsId: 'dockerhubpwd', variable: 'dockerhubpwd')]) {
                   sh 'docker login -u haitamelgharras -p ${dockerhubpwd}'

                   }
                   sh 'docker push haitamelgharras/bankaccountservice:latest'
                }
            }
        }
    }
}