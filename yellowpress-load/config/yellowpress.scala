import com.twitter.parrot.config.ParrotLauncherConfig

new ParrotLauncherConfig {
  jobName = "load_echo"
  port = 8081
  victims = "localhost"

  // traceLevel = com.twitter.logging.Level.TRACE

  // log = "your_input_file_here.log"
  log = "config/yellowpress.log"
  requestRate = 1
  duration = 15
  timeUnit = "MINUTES"
  reuseFile = true
  localMode = true

  imports = "import by.mmf.yellowpress.load.YellowPressLoadTest"
  responseType = "Array[Byte]"
  transport = "ThriftTransport"
  loadTest = "new YellowPressLoadTest(service.get)"
}
