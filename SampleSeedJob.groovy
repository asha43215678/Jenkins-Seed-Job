job ("JOB_NAME") {

    logRotator {
        daysToKeep(10)
        numToKeep(-1)
    }
    steps {
        shell("echo 'hello world'")
    }
}
