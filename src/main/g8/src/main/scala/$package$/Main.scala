package $package$

import scopt.OParser
import com.typesafe.scalalogging.Logger
import java.io.File

case class Config(
  foo: Int = 0,
  files: Seq[File] = Nil
)

object Main extends App {
  val logger = Logger(Main.getClass)
  val builder = OParser.builder[Config]

  val parser = {
    import builder._
    OParser.sequence(
      programName("$name$"),
      opt[Int]('f', "foo")
        .optional()
        .action((x, c) => c.copy(foo = x))
        .text("foo is an integer property"),
      arg[File]("<file>...")
        .unbounded()
        .optional().action((x, c) => c.copy(files = c.files :+ x))
        .text("optional unbounded args")
    )
  }

  OParser.parse(parser, args, Config()) match {
    case Some(config) =>
      // do something
      logger.info(config.toString)
    case _ =>
      // arguments are bad, error message will have been displayed
      logger.error("Failed to parse options")
  }
}
