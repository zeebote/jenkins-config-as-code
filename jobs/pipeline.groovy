pipelineJob('pipeline-example') {
  description("job create by jobDSL plugin")
  definition {
    cpsScm {
      scm {
        git {
          remote {
            url('https://github.com/zeebote/maven-nexus')
          }
          branch('*/develop')
        }
      }
      lightweight()
    }
  }
  triggers {
    githubPush {
      buildOnPushEvents(true)
      buildOnMergeRequestEvents(true)
      commentTrigger("jenkins please")
    }    
  }
}
