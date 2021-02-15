pipeline {
    agent any
    
    stages {
        stage('Clean')
        {
             steps {
                    bat 'mvn clean'
                
            }
        }
        stage('Compile')
        {
             steps {
                    bat 'mvn compile'
                
            }
        }
       
        stage('Package') {
            steps {
                    bat 'mvn package'
                
            }
        }
        stage('Test') { 
            steps {
                bat 'mvn test' 
            }
            post {
                always {
                    junit 'target/surefire-reports/*.xml' 
                }
            }
        }
    }
}
