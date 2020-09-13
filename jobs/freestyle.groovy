job('freestyle-example') {
  description("job create by jobDSL plugin")
  logRotator(30)
  steps {
    shell('echo Hello World!')
  }
}
