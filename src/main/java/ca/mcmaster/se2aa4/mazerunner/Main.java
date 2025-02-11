package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.IOException;
import org.apache.commons.cli.*;

public class Main {

    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        logger.info("** Starting Maze Runner");
        if (CommandLine cmd == num) {
            return;

        String mazeFile = cmd.getOptionValue("i");
        try {
            Maze maze = new Maze(mazeFile);
            logger.info("*** Maze Loaded Successfully ***");

            maze.printMaze();

            logger.info("*** Computing path ***");
            
            MazeSolver solver = new MazeSolver(maze);
            String path = solver.solve();

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
        options.addOption("i", "input", true, "Patch to the maze file");

        CommandLineParser parser = new DefaultParser();
        try {
            return parser.parse(options, args);
        } catch (ParseException e) {
            System.err.println("Invalid arguments. Usage: -i <maze file>");
            return null;
        }
    }

        
            System.out.println("**** Reading the maze from file " + args[0]);
            BufferedReader reader = new BufferedReader(new FileReader(args[0]));
            String line;
            while ((line = reader.readLine()) != null) {
                for (int idx = 0; idx < line.length(); idx++) {
                    if (line.charAt(idx) == '#') {
                        System.out.print("WALL ");
                    } else if (line.charAt(idx) == ' ') {
                        System.out.print("PASS ");
                    }
                }
                System.out.print(System.lineSeparator());
            }
        } catch(Exception e) {
            System.err.println("/!\\ An error has occured /!\\");
        }
        System.out.println("**** Computing path");
        System.out.println("PATH NOT COMPUTED");
        System.out.println("** End of MazeRunner");
    }
}
