def call(String environment_name, String squad_name){
    def myDataMap = [:]
    myDataMap['myKey'] = 'myValue'
    step([$class: 'InfluxDbPublisher',
                  //jenkinsEnvParameterField: 'environment_name=' + "${environment_name}" + " " + "test=test",
                  //jenkinsEnvParameterTag: 'squad_name=' + "${squad_name}" + ",TEST=TEST",
                  customData: myDataMap,
                  measurementName: 'prueba_jenkins',// OPTIONAL, custom fields
                  target: 'prueba_jenkins'])
}
