pipeline {
    agent any

    tools {
        // Assumes Java 21 and Maven are configured in Jenkins Global Tool Configuration,
        // or available in the system path.
        jdk 'jdk21'
        maven 'maven3'
    }

    stages {
        stage('Checkout Code') {
            steps {
                checkout scm
            }
        }

        stage('Build Application') {
            steps {
                // Builds the Spring Boot jar file, skipping tests for quick deployment
                sh 'mvn clean package -DskipTests'
            }
        }

        stage('Deploy to EC2') {
            steps {
                echo 'Deploying Spring Boot application...'
                // Add your deployment commands here (e.g., stopping old jar, starting new jar)
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