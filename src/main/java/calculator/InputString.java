package calculator;

import java.util.LinkedList;
import java.util.Queue;
import java.util.regex.Pattern;

public class InputString {
    public static final String DELIMITER = " ";
    public final Pattern NUMBER_PATTERN = Pattern.compile("[0-9]");
    public final Pattern OPERATOR_PATTERN = Pattern.compile("[+\\-*/]");

    private final String value;
    private final Queue<Integer> numbers = new LinkedList<>();
    private final Queue<String> operators = new LinkedList<>();


    public InputString(String input) {
        if (isNull(input) || isEmpty(input)) {
            throw new IllegalArgumentException();
        }
        this.value = input;
    }

    public void split() {
        String[] splitStrings = value.split(DELIMITER);

        for (String element : splitStrings) {
            checkNumber(element);
            checkOperator(element);
        }
    }

    private void checkOperator(String value) {
        if (OPERATOR_PATTERN.matcher(value).matches()) {
            operators.add(value);
        }
    }

    private void checkNumber(String value) {
        if (NUMBER_PATTERN.matcher(value).matches()) {
            numbers.add(Integer.parseInt(value));
        }
    }

    public int numberCount() {
        return numbers.size();
    }

    public int operatorCount() {
        return operators.size();
    }

    private boolean isNull(String input) {
        return input == null;
    }

    private boolean isEmpty(String input) {
        return input.isEmpty();
    }

    public String getOperator() {
        return operators.remove();
    }

    public int getOneNumber() {
        return numbers.remove();
    }
}
