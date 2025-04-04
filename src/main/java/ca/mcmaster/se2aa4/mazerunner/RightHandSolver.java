package ca.mcmaster.se2aa4.mazerunner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RightHandSolver implements MazeSolver {
  private Static final Logger logger = LogManager.getLogger();

  @Override
  public Path solve(Maze maze) {
    Path path
