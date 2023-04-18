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
        return input.split(",|;");
    }
}
