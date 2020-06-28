Giter8 template for Scala + GraalVM native CLI apps
========

This giter8 template is made allows to build a Scala CLI application which can be translated to a native image by [GraalVM](https://www.graalvm.org/).

How to use
--------

Create your project by `sbt new` specifying this template:

```
$ sbt new takezoe/scala-native-cli.g8
```

To generate a native image, run the following command at the root directory of the created project.

```
$ sbt graalvm-native-image:packageBin
```

The native image is generated in `target/graalvm-native-image` directory.

Note that you need to install GraalVM and `native-image` command beforehand.

1. Download and install GraalVM from: https://github.com/graalvm/graalvm-ce-builds/releases
2. Install `native-image` command as follows:
   ```
   $ gu install native-image
   ```

Libraries
--------

This template includes the following libraries useful to create typical CLI tools and can be translated to a standalone native image.

- [scopt](https://github.com/scopt/scopt)
- [ujson](https://github.com/lihaoyi/upickle)
- [sttp](https://github.com/softwaremill/sttp)
- [scala-logging](https://github.com/lightbend/scala-logging)
- [scalatest](https://github.com/scalatest/scalatest) (test)

Let me know if you know other useful libraries which are worth to include in this template by raising an issue or pull request ;-)
