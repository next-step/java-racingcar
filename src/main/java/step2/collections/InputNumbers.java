package step2.collections;

import java.util.Arrays;

import static step2.constants.RegexPattern.NUMBER_REGEX;

public class InputNumbers {

    private final int[] numbers;

    public InputNumbers(String[] expressions) {
        this.numbers = filterNumber(expressions);
    }

    public int size() {
        return this.numbers.length;
    }

    public int get(Integer index) {
        return this.numbers[index];
    }

    private int[] filterNumber(String[] stringArray) {
        return Arrays.stream(stringArray)
                .filter(string -> NUMBER_REGEX.matcher(string).matches())
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
