package calculator;

public class Calculator {

    private static final String DELIMITER = ",|:";
    private static final int CUSTOM_DELIMITER_INDEX = 1;
    private static final int CUSTOM_TEXT_INDEX = 2;

    public static int calculate(String text) {
        if(isBlank(text)) {
            return 0;
        }
        return sum(toInts(split(text)));
    }

    private static boolean isBlank(String text) {
        return text == null || text.isBlank();
    }

    private static String[] split(String text) {
        if(isCustom(text)) {
            return customSplit(text);
        }
        return text.split(DELIMITER);
    }

    private static int[] toInts(String[] values) {
        int[] numbers = new int[values.length];
        for (int i = 0; i < values.length; ++i) {
            numbers[i] = Integer.parseInt(values[i]);
        }
        return numbers;
    }

    private static int sum(int[] numbers) {
        includeMinus(numbers);
        int sum = 0;
        for(int number: numbers) {
            sum += number;
        }
        return sum;
    }

    private static boolean isCustom(String text) {
        if(text.split("//|\n").length == 3) {
            return true;
        }
        return false;
    }

    private static String[] customSplit(String text) {
        String[] textList = text.split("//|\n");
        return textList[CUSTOM_TEXT_INDEX].split(textList[CUSTOM_DELIMITER_INDEX]);
    }

    private static void includeMinus(int[] numbers) {
        for (int number : numbers) {
            validatePositive(number);
        }
    }

    private static void validatePositive(int number){
        if(number < 0) {
            throw new IllegalArgumentException("DO NOT INPUT MINUS NUMBER");
        }
    }
}
