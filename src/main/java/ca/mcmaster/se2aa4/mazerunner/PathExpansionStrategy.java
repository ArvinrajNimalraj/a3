package ca.mcmaster.se2aa4.mazerunner;

public class DefaultPathExpansionStrategy implements PathExpansionStrategy {
    @Override
    public String expand(String path) {
        StringBuilder expanded = new StringBuilder();

        for (int i = 0; i < path.length(); i++) {
            if (!Character.isDigit(path.charAt(i))) {
                expanded.append(path.charAt(i));
            } else {
                int count = 0;
                int digit = 0;
                do {
                    count *= (int) Math.pow(10, digit++);
                    count += Character.getNumericValue(path.charAt(i++));
                } while (Character.isDigit(path.charAt(i)));

                String step = String.valueOf(path.charAt(i)).repeat(count);
                expanded.append(step);
            }
        }
        return expanded.toString();
    }
}
