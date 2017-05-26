node {
	checkout scm
	stage('Package') {
		dir('src') {
      		sh 'mvn clean package -DskipTests'
		}	
  	}
}

