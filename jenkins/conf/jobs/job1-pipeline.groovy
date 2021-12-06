#!groovy

pipeline {
    agent any
    tools {
        maven 'maven'
    }
    environment {
        TEST = 'TEST'
    }
    options {
        buildDiscarder(logRotator(numToKeepStr: '100'))
        ansiColor('xterm')
    }
    stages {
        stage('Job description') {
            steps {
                script {
                    println('Env var: ' + env.TEST)
                    sh 'java --version'
                    sh 'mvn --version'
                    sh 'python3 --version'
                    currentBuild.displayName = "#${BUILD_NUMBER} ${params.PARAM1}"
                }
            }
        }
        stage('Recupération du projet Git') {
            steps {
                script {
                    println('Connexion au git: ')
                    checkout([$class: 'GitSCM', branches: [[name: params.BRANCH]], extensions: [], userRemoteConfigs: [[url: 'https://github.com/Ozz007/sb3t']]])
                }
            }
        }
        stage('compile Jar') {
            steps {
                script {
                    println('Création du .jar: ')
                    sh 'mvn clean compile'
                }
            }
        }
        stage('Test') {
            when{
                expression{params.SKIP_TEST==false}
            }
            steps {
                script {
                    sh 'mvn test'
                    
                }
            }
        }
        stage('build Jar') {
            steps {
                script {
                    println('test du .jar: ')
                    sh 'mvn package'
                }
            }
        }

    }
}