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
                  customData: dataMap,
                  measurementName: 'prueba_jenkins',
                  target: 'prueba_jenkins'])
}
