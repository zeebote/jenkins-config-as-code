job('seed-all') {
  triggers {
    githubPush {
      buildOnPushEvents(true)
    }    
  }
  scm {
    git {
      remote {
        url ('https://github.com/zeebote/jenkins-config-as-code.git')
      }
      branch('*/develop')
    }
  }
  steps {
    dsl {
      external('jobs/*.groovy')
      removeAction('DELETE')
    }
  }
}
