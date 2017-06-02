node {
	checkout scm
	env.JAVA_HOME = tool 'Java8'
	env.PATH = "${tool 'Maven3'}/bin:${env.PATH}"
	
	stage('Package') {		
		sh 'mvn clean package -DskipTests'
  	}

	docker.withTool("Docker") {
		withDockerServer(uri: "${DOCKER_SERVER}") {
			stage('Create Docker Image') {
				docker.build("chakravd/microsvc:${env.BUILD_NUMBER}")
			}
		}
	}
}

