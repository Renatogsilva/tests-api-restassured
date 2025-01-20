pipeline{
    agent any

    tools {
        maven 'Maven'
    }

    stages {
        stage('Build') {
            steps {
                sh "mvn clean install -DskipTests"
            }
        }

        stage('Test') {
            steps {
                script{
                    catchError(buildResult: 'UNSTABLE', stageResult: 'FAILURE'){
                        sh "mvn test"
                    }
                }
            }
        }

        stage('Reports') {
            steps{
                script{
                    allure includeProperties: false, jdk: '', results: [[path: 'allure-results']]
                }
            }
        }
    }


}