node {
	checkout scm
	stage('Package') {
		dir('webapp') {
      		sh 'mvn clean package -DskipTests'
		}	
  	}
}

