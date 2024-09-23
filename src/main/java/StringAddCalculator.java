public class StringAddCalculator {
    public int splitAndSum(String input) {
        if (input == null || input.equals("")) {
            return 0;
        }

        if (input.length() == 1) {
            return Integer.parseInt(input);
        }
        return 0;
    }
}
