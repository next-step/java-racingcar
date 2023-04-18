public class StringCalculator {

    public int sum(String input) {
        if (isBlank(input)) {
            return 0;
        }

        return add(parseStringToIntegers(split(input)));
    }

    private boolean isBlank(String input) {
        return input == null || input.isEmpty();
    }

    private int add(int[] parsedNumbers) {
        int sum = 0;

        for (int parsedNumber : parsedNumbers) {
            sum += parsedNumber;
        }

        return sum;
    }

    private int[] parseStringToIntegers(String[] inputComponents) {
        final int[] parsedNumbers = new int[inputComponents.length];

        for (int i = 0; i < inputComponents.length; i++) {
            parsedNumbers[i] = Integer.parseInt(inputComponents[i]);
        }
        return parsedNumbers;
    }

    public String[] split(String input) {
        if (hasCustomDelimiter(input)) {
            input = input.substring(5);
            final String delimiter = input.substring(1, 2);

            return input.split(delimiter);
        }

        return input.split(",|;");
    }

    private boolean hasCustomDelimiter(String input) {
        return input.contains("//") && input.contains("\\n");
    }
}
