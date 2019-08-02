def call(String environment_name, String squad_name){
    def dataMap = [:]
    dataMap['environment_name'] = "${environment_name}"
    dataMap['squad_name'] = "${squad_name}"
    dataMap['build_result'] =  "${currentBuild.currentResult}"
    if("${currentBuild.currentResult}"=='SUCCESS'){
        dataMap['build_result_ordinal'] =  0
    }
    if("${currentBuild.currentResult}"=='FAILURE'){
        dataMap['build_result_ordinal'] =  2
    }
    if("${currentBuild.currentResult}"=='UNSTABLE'){
        dataMap['build_result_ordinal'] =  0
    }
    step([$class: 'InfluxDbPublisher',
                  //jenkinsEnvParameterField: 'environment_name=' + "${environment_name}" + " " + "test=test",
                  //jenkinsEnvParameterTag: 'squad_name=' + "${squad_name}" + ",TEST=TEST",
                  customData: dataMap,
                  measurementName: 'prueba_jenkins',// OPTIONAL, custom fields
                  target: 'prueba_jenkins'])
}
