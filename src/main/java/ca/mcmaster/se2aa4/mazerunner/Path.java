package ca.mcmaster.se2aa4.mazerunner;

import java.util.ArrayList;
import java.util.List;

public class Path {
    private final List<Character> path = new ArrayList<>();

    /**
     * Initialize an empty Path.
     */
    public Path() {
    }

    /**
     * Initialize path from a Path String.
     *
     * @param pathStr The Path String
     */
    public Path(String pathStr) {
        String expanded = expandFactorizedStringPath(pathStr);
        for (Character c : expanded.toCharArray()) {
            if (c != ' ') {
                if (c != 'F' && c != 'L' && c != 'R') {
                    thpackage ca.mcmaster.se2aa4.mazerunner;

import java.util.ArrayList;
import java.util.List;

public class Path {
    private final List<Character> path = new ArrayList<>();
    private PathExpansionStrategy expansionStrategy;

    public Path(String pathStr, PathExpansionStrategy strategy) {
        this.expansionStrategy = strategy != null ? strategy : new DefaultPathExpansionStrategy();
        if (pathStr != null && !pathStr.isEmpty()) {
            String expanded = this.expansionStrategy.expand(pathStr);
            for (Character c : expanded.toCharArray()) {
                if (c != ' ') {
                    if (c != 'F' && c != 'L' && c != 'R') {
                        throw new IllegalArgumentException("Instruction '" + c + "' is invalid. Must be 'F', 'L', or 'R'.");
                    }
                    addStep(c);
                }
            }
        }
    }

    public List<Character> getPathSteps() {
        return new ArrayList<>(this.path);
    }

    public void addStep(Character step) {
        path.add(step);
    }

    public String getCanonicalForm() {
        StringBuilder sb = new StringBuilder();

        for (Character c : path) {
            if (sb.isEmpty() || sb.charAt(sb.length() - 1) == c) {
                sb.append(c);
            } else {
                sb.append(' ');
                sb.append(c);
            }
        }

        return sb.toString();
    }

    public String getFactorizedForm() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < path.size(); i++) {
            Character current = path.get(i);
            int count = 0;
            while (i < path.size() && current == path.get(i)) {
                count++;
                i++;
            }

            if (count == 1) {
                sb.append(current);
            } else {
                sb.append(count);
                sb.append(current);
            }

            if (i != path.size()) {
                sb.append(' ');
            }
            i--;
        }

        return sb.toString();
    }
}
