package step2;

import step2.dto.StringAddCalculatorDto;

public class StringAddCalculator {

    static SeparatorFinder sf = new SeparatorFinder();

    public static int splitAndSum(String str) {
        if (isBlank(str)) return 0;

        StringAddCalculatorDto calcDto = sf.getStringAddCalculatorDto(str);

        return sum(toInts(split(calcDto.getText(), calcDto.getSeparatorRegex())));
    }

    private static String[] split(String text, String separatorRegex) {
        return text.split(separatorRegex);
    }

    private static boolean isBlank(String str) {
        return str == null || str.equals("");
    }

    private static int sum(int[] numbers) {
        int sum = 0;
        for (int number : numbers) {
            checkInvalidNumber(number);
            sum += number;
        }
        return sum;
    }

    private static void checkInvalidNumber(int number) {
        if (number < 0)
            throw new RuntimeException();
    }

    private static int[] toInts(String[] strNumbers) {
        int[] numbers = new int[strNumbers.length];
        for (int i = 0; i < strNumbers.length; i++) {
            numbers[i] = isBlank(strNumbers[i]) ? 0 : Integer.parseInt(strNumbers[i]);
        }
        return numbers;
    }
}
