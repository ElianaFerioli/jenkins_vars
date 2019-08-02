def call(String environment_name, String squad_name){
    def dataMap = [:]
    def dataMapNew = [:]
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
    def squads = squad_name.split(',')
    print "dasdasdasads"
    for(squad in squads){
        dataMapNew['TEST_' + squad] = squad
    }
    def customDataMap = [:]
    customDataMap['jenkins_data_1'] = dataMap
    customDataMap['jenkins_data_2'] = dataMapNew    
    step([$class: 'InfluxDbPublisher',
                  //jenkinsEnvParameterField: 'environment_name=' + "${environment_name}" + " " + "test=test",
                  //jenkinsEnvParameterTag: 'squad_name=' + "${squad_name}" + ",TEST=TEST",
                  customDaraMap: customDataMap,
                  //customData: dataMap,
                  measurementName: 'prueba_jenkins',// OPTIONAL, custom fields
                  target: 'prueba_jenkins'])
}
