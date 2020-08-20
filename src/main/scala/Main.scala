import com.google.api.services.dataflow.model.JobMetrics
import com.spotify.scio.ScioContext
import com.typesafe.scalalogging.StrictLogging
import org.apache.beam.runners.dataflow.options.DataflowPipelineOptions
import org.apache.beam.sdk.options.Validation.Required
import org.apache.beam.sdk.options.{Default, Description, PipelineOptions, PipelineOptionsFactory, ValueProvider}
import org.apache.beam.sdk.transforms.Create

object Main extends App with StrictLogging {

  trait Options extends PipelineOptions with DataflowPipelineOptions {
    @Description("Start datatime to process files")
    @Required
    def getStartDateTime: ValueProvider[String]

    def setStartDateTime(value: ValueProvider[String]): Unit

    @Description(
      "If the job is sandbox. If true, will only process 1 minute of data.")
    @Default.Boolean(false)
    def getIsSandbox: Boolean
    def setIsSandbox(value: Boolean): Unit

  }

  override def main(cmdlineArgs: Array[String]): Unit = {
    logger.info(s"Provided options: $cmdlineArgs")

    PipelineOptionsFactory.register(classOf[Options])
    val pipelineOptions: Options = PipelineOptionsFactory
      .fromArgs(cmdlineArgs: _*)
      .withValidation
      .as(classOf[Options])

    val sc          = ScioContext(pipelineOptions)

    sc.customInput("Input",
      Create.of(1, 2, 3, 4, 5, 6))
      .map(x => x * 2)

    sc.run()


  }
}
