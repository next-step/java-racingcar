package calculator;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ElementGenerator {

    private final String input;
    private final LinkedList<String> numbers;
    private final LinkedList<String> operators;

    public ElementGenerator(String input) {
        this.input = input;
        validateFormat();

        input = input.replaceAll(" ", "");
        numbers = new LinkedList<>(Arrays.asList(input.split("[-+*/]")));
        operators = Arrays.stream(input.split("[0-9]+")).filter(operand -> !operand.isEmpty())
            .collect(Collectors.toCollection(LinkedList::new));
    }

    private void validateFormat() {
        if ( isEmptyOrNull(input) || isNotMatched(Pattern.compile("^\\d+(\\s*[-+*/]\\s*\\d+)+$"))) {
            throw new IllegalArgumentException("[ERROR] 식의 포맷이 유효하지 않습니다.");
        }
    }

    private boolean isEmptyOrNull (String input) {
        return input == null || input.isEmpty();
    }

    private boolean isNotMatched(Pattern pattern) {
        return !pattern.matcher(input).matches();
    }

    public LinkedList<String> getNumbers() {
        return numbers;
    }

    public LinkedList<String> getOperators() {
        return operators;
    }
}
