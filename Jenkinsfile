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
			withDockerRegistry('https://registry.hub.docker.com', 'docker-registry-login') {
				def image_
				stage('Create Docker Image') {
					image_ = docker.build("chakravd/microsvc:${env.BUILD_NUMBER}")
				}
			
				stage('Push Docker Image') {
					image_.push()
				}
			}
		}
	}
}

