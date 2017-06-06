#!groovy​
node {
	env.JAVA_HOME = tool 'Java8'
	env.PATH = "${tool 'Maven3'}/bin:${env.PATH}"

	stage('Checkout Source')
	checkout scm

	stage('Package')
	sh 'mvn clean package -DskipTests'

	docker.withTool("Docker") {
		withDockerServer(uri: "${DOCKER_SERVER}") {
			withDockerRegistry(url: 'https://index.docker.io/v1/', credentialsId: 'docker-registry-login') {
				def image_
				stage('Create Docker Image')
				//image_ = docker.build("chakravd/microsvc:${env.BUILD_NUMBER}")
				image_ = docker.build("chakravd/microsvc:latest")

				//stage('Push Docker Image')
				//image_.push("latest")
			}
		}
	}

	stage("Deploy to OpenShift 3")
	openshiftDeploy(deploymentConfig: 'microsvc')
	openshiftScale(deploymentConfig: 'microsvc',replicaCount: '2')
}
