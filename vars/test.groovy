def call(String environment){
    step([$class: 'InfluxDbPublisher',
                  customData: null,
                  customDataMap: null,
                  customPrefix: null,
                  //jenkinsEnvParameterTag: 'KEY=' + env.BUILD_NUMBER,
                  jenkinsEnvParameterField: 'environment=' + ${environment},
                  measurementName: 'prueba_jenkins',// OPTIONAL, custom fields
                  target: 'prueba_jenkins'])
}
