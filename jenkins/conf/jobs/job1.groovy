#!groovy
println('------------------------------------------------------------------Import Job CI/Job1')
def pipelineScript = new File('/var/jenkins_config/jobs/job1-pipeline.groovy').getText("UTF-8")

pipelineJob('CI/Job1') {
    description("Job Pipline 1")
    parameters {
        stringParam {
            name('BRANCH')
            defaultValue('master')
            description("String pour sélectionner la branche du repo Github")
            trim(false)
        }
        booleanParam{
            name('SKIP_TESTS')
            defaultValue(false)
            description("Contrôler l'exécution des tests. Par defaut : Ne pas lancer les tests")
        }
        choice{
            name('VERSION_TYPE')
            choices(['SNAPSHOT', 'RELEASE'])
            description("Version type")
        }
        stringParam{
            name('VERSION')
            defaultValue("SB3T-1.0-SNAPSHOT")
            description("Un string pour la version du jar (ex: SB3T-1.0-SNAPSHOT)")
            trim(false)
        }
    }
    definition {
        cps {
            script(pipelineScript)
            sandbox()
        }
    }
}