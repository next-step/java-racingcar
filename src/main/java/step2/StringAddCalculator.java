package step2;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");

    public static int splitAndAdd(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        return add(split(parseInputExpression(input)));
    }

    public static int add(String[] strNumbers) {
        int sum = 0;

        for (String strNumber : strNumbers) {
            sum += parseInt(strNumber);
        }

        return sum;
    }

    public static int parseInt(String maybeNumberString) {
        try {
            int parsedValue = Integer.parseInt(maybeNumberString);

            if (parsedValue < 0) {
                throw new RuntimeException();
            }

            return parsedValue;
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    public static int add(Integer[] numbers) {
        int sum = 0;

        for (Integer number : numbers) {
            sum += number;
        }

        return sum;
    }

    public static String[] split(Input input) {
        return input.getInput().split(input.getDelimiter());
    }

    public static String extractDelimiter(String input) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(input);

        if (m.find()) {
            return m.group(1);
        }

        return null;
    }

    public static boolean hasCustomDelimiter(String input) {
        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(input);
        return matcher.find();
    }

    public static String getCustomDelimiter(String input) {
        if (hasCustomDelimiter(input)) {
            Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(input);
            return matcher.find() ? matcher.group(1) : input;
        }

        return input;
    }

    public static String removeCustomDelimiter(String input) {
        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(input);
        if (matcher.find()) {
            return matcher.group(2);
        }

        return input;
    }

    public static String getValidInput(String input) {
        if (hasCustomDelimiter(input)) {
            return removeCustomDelimiter(input);
        }

        return input;
    }

    public static Input parseInputExpression(String input) {
        if (hasCustomDelimiter(input)) {
            return new Input(input, getValidInput(input), getCustomDelimiter(input));
        }

        return Input.hasNoDelimiter(input);
    }

    public static class Input {
        private static final String DEFAULT_DELIMITERS = ",|:";

        private String originalInput;
        private String delimiterRemovedInput;
        private String customDelimiter;

        private Input(String originalInput, String delimiterRemovedInput, String customDelimiter) {
            this.originalInput = originalInput;
            this.delimiterRemovedInput = delimiterRemovedInput;
            this.customDelimiter = customDelimiter;
        }

        public static Input hasDelimiter(String input, String delimiterRemovedInput, String customDelimiter) {
            return new Input(input, delimiterRemovedInput, customDelimiter);
        }

        public static Input hasNoDelimiter(String input) {
            return new Input(input, input, "");
        }

        public boolean useCustomDelimiter() {
            return customDelimiter != null && !customDelimiter.isBlank();
        }

        public String getDelimiter() {
            return useCustomDelimiter() ? customDelimiter : DEFAULT_DELIMITERS;
        }

        public String getInput() {
            return useCustomDelimiter() ? delimiterRemovedInput : originalInput;
        }

        public String[] split() {
            return getInput().split(getDelimiter());
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof Input)) {
                return false;
            }
            Input input = (Input) o;
            return originalInput.equals(input.originalInput) && Objects.equals(delimiterRemovedInput,
                    input.delimiterRemovedInput) && Objects.equals(customDelimiter, input.customDelimiter);
        }

        @Override
        public int hashCode() {
            return Objects.hash(originalInput, delimiterRemovedInput, customDelimiter);
        }
    }
}
