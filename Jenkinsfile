node {
	env.JAVA_HOME = tool 'Java8'
	env.PATH = "${tool 'Maven3'}/bin:${env.PATH}"
	
	stage('Checkout Source') {
		checkout scm
	}

	stage('Package') {		
		sh 'mvn clean package -DskipTests'
  	}

	docker.withTool("Docker") {
		withDockerServer(uri: "${DOCKER_SERVER}") {
			stage('Create Docker Image') {
				def image_ = docker.build("chakravd/microsvc:${env.BUILD_NUMBER}")
				image_.push()
			}
			
			stage('Push Docker Image') {
				image_.push()
			}
		}
	}
}

