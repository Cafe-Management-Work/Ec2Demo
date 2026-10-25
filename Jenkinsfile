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
                // Give execution permission to gradlew and build the project
                sh 'chmod +x gradlew'
                sh './gradlew build -x test'
            }
        }

        stage('Deploy to EC2') {
            steps {
                echo 'Deploying Spring Boot application...'
                // Gradle builds jars into the build/libs/ directory
                sh 'nohup java -jar build/libs/*.jar > app.log 2>&1 &'
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