import org.apache.commons.cli.*;

public class MazeRunnerCLI {
  public static CommandLine parseArguments(String[] args) {
    Options options = new Options();
    options.addOption("i", "input", true, "Path to the maze file");
    options.addOption("p", "path", true, "Path to verify");

    CommandLineParser parser =new DefaultParser();
    try { 
        return parser.parse(options, args);
    } catch (ParseException e) {
        System.err.println("Invalid command line arguments.");
        System.exit(1);
        return null:
    }
  }
}
