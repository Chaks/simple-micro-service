node {
	checkout scm
	env.JAVA_HOME = tool 'Java8'
	env.PATH = "${tool 'Maven3'}/bin:${env.PATH}"
	stage('Package') {
		dir('src') {
      		sh 'mvn clean package -DskipTests'
		}	
  	}
}

