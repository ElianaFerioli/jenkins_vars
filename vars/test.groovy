def testInflux(){
    step([$class: 'InfluxDbPublisher',
                  customData: null,
                  customDataMap: null,
                  customPrefix: null,
                  //jenkinsEnvParameterTag: 'KEY=' + env.BUILD_NUMBER,
                  jenkinsEnvParameterField: 'environment=develop',
                  measurementName: 'prueba_jenkins',// OPTIONAL, custom fields
                  target: 'prueba_jenkins'])
      } 
}
