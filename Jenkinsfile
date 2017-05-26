node {
	checkout scm
	env.PATH = "${tool 'Maven3'}/bin:${env.PATH}"
  	stage('Package') {
		dir('webapp') {
      		sh 'mvn clean package -DskipTests'
		}	
  	}
}

