node {
	checkout scm
	env.JAVA_HOME = tool 'Java8'
	env.PATH = "${tool 'Maven3'}/bin:${env.PATH}"
	
	stage('Package') {		
		sh 'mvn clean package -DskipTests'
  	}

	
	env.DOCKER_SERVER = 'tcp://localhost'

	docker.withTool("Docker") {
		withDockerServer(uri: ${env.DOCKER_SERVER}) {
			stage('Create Docker Image') {
				docker.build("chakravd/microsvc:${env.BUILD_NUMBER}")
			}
		}
	}
}

