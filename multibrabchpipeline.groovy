folder('multi-seed') {
    displayName('multi-seed')
    description('Folder for multi-sed')
}

folder('multi-seed/application') {
  multibranchPipelineJob('Microservice/application/sample-app') {
    branchSources {
      branchSource {
        source {
         git {
          id('sample-app')
          remote('https://github.com/asha43215678/project2')
          }
        }
        strategy {
                    defaultBranchPropertyStrategy {
                        props {
                            noTriggerBranchProperty()
                       }
                  }
             }
         }
    }
    configure {
        def traits = it / sources / data / 'jenkins.branch.BranchSource' / source / traits
        traits << 'jenkins.plugins.git.traits.BranchDiscoveryTrait' {}
    }
        factory {
            workflowBranchProjectFactory {
                scriptPath('Jenkinsfile')
            }
        }
    orphanedItemStrategy {
        discardOldItems {
            numToKeep(20)
        }
     }
   }
}
