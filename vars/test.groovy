def call(String environment_name, String squad_name){
    def myDataMap = [:]
    myDataMap['environment_name'] = "${environment_name}"
    myDataMap['squad_name'] = "${squad_name}"
    step([$class: 'InfluxDbPublisher',
                  //jenkinsEnvParameterField: 'environment_name=' + "${environment_name}" + " " + "test=test",
                  //jenkinsEnvParameterTag: 'squad_name=' + "${squad_name}" + ",TEST=TEST",
                  customData: myDataMap,
                  measurementName: 'prueba_jenkins',// OPTIONAL, custom fields
                  target: 'prueba_jenkins'])
}
