package ca.mcmaster.se2aa4.mazerunner;

public class PathBuilder {
    private String pathStr;
    private PathExpansionStrategy expansionStrategy;

    public PathBuilder() {
        this.expansionStrategy = new DefaultPathExpansionStrategy(); // Default Strategy
    }

    public PathBuilder withPathString(String pathStr) {
        this.pathStr = pathStr;
        return this;
    }

    public PathBuilder withExpansionStrategy(PathExpansionStrategy strategy) {
        this.expansionStrategy = strategy;
        return this;
    }

    public Path build() {
        return new Path(pathStr, expansionStrategy);
    }
}
