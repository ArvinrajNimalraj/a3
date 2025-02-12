package ca.mcmaster.se2aa4.mazerunner;

import java.util.ArrayList;
import java.util.List;

public class Path {
    private final List<Character> steps;

  public Path() {
    this.steps = new ArrayList<>();
  }

  public void addStep(char step) {
    steps.add(step);
  }

  public String getCanonicalForm() {
    StringBuilder result = new StringBuilder();
    for(char step : steps) {
      result.append(step);
    }
    return result.toString();
  }

    public booleean isEmpty() {
        return steps.isEmpty();
    }
}
