pipeline {
    agent any

    stages {
        stage('Checkout Code') {
            steps {
                checkout scm
            }
        }

        stage('Build Application') {
            steps {
                // If your project uses Maven:
                sh 'mvn clean package -DskipTests'

                // (Or if your project uses Gradle, uncomment below instead):
                // sh './gradlew build -x test'
            }
        }

        stage('Deploy to EC2') {
            steps {
                echo 'Deploying Spring Boot application...'
                sh 'nohup java -jar target/*.jar > app.log 2>&1 &'
            }
        }
    }

    post {
        success {
            echo 'Pipeline completed successfully!'
        }
        failure {
            echo 'Pipeline failed. Check console output for details.'
        }
    }
}