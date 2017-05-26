node {
	checkout scm
	env.PATH = "${tool 'Maven3'}/bin:${env.PATH}"
	stage('Package') {
		dir('src') {
      		sh 'mvn clean package -DskipTests'
		}	
  	}
}

