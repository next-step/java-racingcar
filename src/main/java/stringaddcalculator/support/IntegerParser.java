package stringaddcalculator.support;

public class IntegerParser {

    private IntegerParser() {
    }

    public static int parsePositiveInteger(final String inputString) {
        int parseInt;

        try {
            parseInt = Integer.parseInt(inputString);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자 양식만 입력 바랍니다.");
        }

        if (isNegative(parseInt)) {
            throw new IllegalArgumentException("양수만 입력 가능합니다.");
        }

        return parseInt;
    }

    private static boolean isNegative(final int number) {
        return number < 0;
    }
}
