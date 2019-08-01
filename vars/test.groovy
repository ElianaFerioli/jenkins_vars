def call(String environment_name, String squad_name){
    def myDataMap = [:]
    myDataMap['squad'] = "${squad_name}"
    step([$class: 'InfluxDbPublisher',
                  customDataMap: myDataMap,
                  //jenkinsEnvParameterField: 'environment_name=' + "${environment_name}",
                  measurementName: 'prueba_jenkins',// OPTIONAL, custom fields
                  target: 'prueba_jenkins'])
}
