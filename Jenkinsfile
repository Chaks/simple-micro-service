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
			withDockerRegistry(url: 'https://registry.hub.docker.com', credentialsId: 'docker-registry-login') {
				stage('Create Docker Image') {
					docker.build("chakravd/microsvc:${env.BUILD_NUMBER}")
				}
			
				stage('Push Docker Image') {
					docker.build("chakravd/microsvc:${env.BUILD_NUMBER}").push()
				}
			}
		}
	}
}

