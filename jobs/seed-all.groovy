job('seed-all') {
  triggers {
    gitlabPush {
      buildOnPushEvents(true)
    }    
  }
  scm {
    git {
      remote {
        url ('https://github.com/zeebote/jenkins-config-as-code.git')
      }
      branch('*/master')
    }
  }
  steps {
    dsl {
      external('jobs/**/*.groovy')
      removeAction('DELETE')
    }
  }
}
