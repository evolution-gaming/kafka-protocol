# Disclaimer

This is a temporary fork with purpose of publishing the build with the following merge request:
https://github.com/Spinoco/protocol/pull/45

For all other purposes please refer to https://github.com/Spinoco/protocol.

# Usage

```sbt
libraryDependencies ++= Seq(
  "com.spinoco" %% "fs2-kafka" % "0.4.0" exclude (
    "com.spinoco", "protocol-kafka_2.12"
  ),
  "com.evolutiongaming" %% "protocol-kafka" % "0.3.17-evolution2"
)
```
