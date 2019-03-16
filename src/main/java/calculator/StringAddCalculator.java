package calculator;

import java.util.stream.IntStream;

public class StringAddCalculator {
    private static final int CUSTOM_POSITION = 2;

    public int add(String input) {
        String separator = ",|:";

        if (this.isEmpty(input)) {
            return 0;
        }

        if (this.isCustom(input)) {
            separator = String.valueOf(input.charAt(CUSTOM_POSITION));
            input = input.split("\\n")[1];
        }

        return this.addNumbers(this.characterToNumber(input.split(separator)));
    }


    private boolean isEmpty(String input) {
        return input == null || input.trim().isEmpty();
    }

    protected boolean isCustom(String input) {
        return input.indexOf("//") == 0;
    }

    private int[] characterToNumber(String[] characters) {
        int size = characters.length;
        int [] numbers = new int[size];

        IntStream.range(0, size).forEach(i -> {
            String number = characters[i];
            if (isInteger(number)) {
                numbers[i] = Integer.parseInt(number);
            }
        });
        return numbers;
    }

    protected boolean isInteger(String a) {
        try {
            return Integer.parseInt(a) >= 0;
        } catch (NumberFormatException e) {
            throw new RuntimeException();
        }
    }

    private int addNumbers(int[] numbers) {
        return IntStream.of(numbers).sum();
    }
}