package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.commons.cli.*;

public class Main {

    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        logger.info("** Starting Maze Runner");

        // Parse command line arguments
        CommandLine cmd = parseArguments(args);
        if (cmd == null || !cmd.hasOption("i")) {
            logger.error("Missing required input file argument (-i <maze file>)");
            System.err.println("Error: Missing required input file argument (-i <maze file>)");
            return;
        }

        String mazeFile = cmd.getOptionValue("i");
        
        try {
            Maze maze = new Maze(mazeFile);
            MazeSolverImpl solver = new MazeSolverImpl();
            
            logger.info("*** Maze Loaded Successfully ***");
            maze.printMaze();

            logger.info("*** Computing path ***");
            Path path = solver.solve(maze);

            if (path.isEmpty()) {
                logger.warn("No path found!");
                System.out.println("PATH NOT FOUND");
            } else {
                System.out.println("Path: " + path);
                logger.info("Path computed: " + path);
            }

        } catch (IOException e) {
            logger.error("Error reading maze file", e);
        }

        logger.info("*** End of MazeRunner ***");
    }

    private static CommandLine parseArguments(String[] args) {
        Options options = new Options();
        options.addOption("i", "input", true, "Path to the maze file");

        CommandLineParser parser = new DefaultParser();
        try {
            return parser.parse(options, args);
        } catch (ParseException e) {
            logger.error("Invalid arguments, Usage: -1 <maze file>", e);
            System.err.println("Invalid arguments. Usage: -i <maze file>");
            return null;
        }
    }
}
