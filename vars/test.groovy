def call(String environment){
    step([$class: 'InfluxDbPublisher',
                  jenkinsEnvParameterField: 'environment=' + "${environment}",
                  measurementName: 'prueba_jenkins',// OPTIONAL, custom fields
                  target: 'prueba_jenkins'])
}
