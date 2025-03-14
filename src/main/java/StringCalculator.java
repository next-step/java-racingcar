public class StringCalculator {
    public static final String DELIMITERS_REGEX = "[,:]";
    private final String text;

    public StringCalculator(String text) {
        this.text = text;
    }

    public int calc() {
        if (isEmptyOrNull(text)) {
            return 0;
        }

        return sum(parseStrsToInts(splitUserInput()));
    }

    private boolean isEmptyOrNull(String str) {
        return str == null || str.isEmpty();
    }

    private String[] splitUserInput() {
        return text.split(DELIMITERS_REGEX);
    }

    private int[] parseStrsToInts(String[] inputs) {
        int[] result = new int[inputs.length];
        for (int i = 0; i < inputs.length; i++) {
            result[i] = parseInt(inputs[i]);
        }
        return result;
    }

    private int parseInt(String input) {
        int parsedNumber = Integer.parseInt(input);

        if (parsedNumber < 0) {
            throw new RuntimeException("negative number is not allowed");
        }
        return parsedNumber;
    }

    private int sum(int[] numbers) {
        int result = 0;

        for (int number : numbers) {
            result += number;
        }

        return result;
    }
}
