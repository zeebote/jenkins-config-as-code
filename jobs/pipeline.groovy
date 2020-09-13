pipelineJob('pipeline-example') {
  description("job create by jobDSL plugin")
  definition {
    cpsScm {
      scm {
        git {
          remote {
            url('https://github.com/zeebote/maven-dep')
          }
          branch('*/master')
        }
      }
      lightweight()
    }
  }
}
