package stringAddCalculator;

public class StringAddCalculator {
    private static final String EMPTY_STRING = "";
    private static final int START_INDEX = 4;

    public static Integer splitAndSum(String stringNumber) {
        if (verifyStringNumberEmpty(stringNumber)) {
            return 0;
        }

        String[] stringNumbers = createSplittedNumbers(stringNumber);
        if (isEmptyNumberArray(stringNumbers)) return 0;

        return sum(stringNumbers);
    }

    private static boolean verifyStringNumberEmpty(String stringNumber) {
        return stringNumber == null || stringNumber.isBlank();
    }

    private static boolean isEmptyNumberArray(String[] split) {
        return split == null || split.length == 0;
    }

    private static Integer sum(String[] split) {
        Integer sum = 0;
        for (String number : split) {
            sum += formatNumber(number);
        }
        return sum;
    }

    private static Integer formatNumber(String number) {
        try {
            int parseInt = Integer.parseInt(number);
            if (parseInt < 0) {
                throw new NumberFormatException();
            }
            return parseInt;
        } catch (Exception e) {
            throw new NumberFormatException("양수의 숫자만 입력해주세요");
        }
    }

    private static String[] createSplittedNumbers(String str) {
        StringNumberDelimiter.StringDelimiter stringDelimiter = StringNumberDelimiter.getDelimiter(str);
        String delimiter = stringDelimiter.getDelimiter();

        if (stringDelimiter.isCustomDelimiter()) {
            return str.substring(START_INDEX).split(delimiter);
        }

        if (EMPTY_STRING.equals(delimiter)) {
            return null;
        }

        return str.split(delimiter);
    }
}
