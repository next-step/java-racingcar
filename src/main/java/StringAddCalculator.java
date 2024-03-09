import java.util.HashSet;
import java.util.Set;

public class StringAddCalculator {
    private static final String EMPTY_STRING = "";

    public static Integer splitAndSum(String stringNumber) {
        if (verifyStringNumberEmpty(stringNumber)) {
            return 0;
        }

        String[] stringNumbers = createSplitNumbersByStringNumber(stringNumber);
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
            try {
                int parseInt = Integer.parseInt(number);
                if (parseInt < 0) {
                    throw new NumberFormatException();
                }
                sum += parseInt;
            } catch (Exception e) {
                throw new NumberFormatException("양수의 숫자만 입력해주세요");
            }
        }
        return sum;
    }

    private static String[] createSplitNumbersByStringNumber(String str) {
        StringNumberDelimiter.StringDelimiter stringDelimiter = StringNumberDelimiter.getDelimiter(str);
        String delimiter = stringDelimiter.getDelimiter();

        if (stringDelimiter.isCustomDelimiter()) {
            return str.substring(4).split(delimiter);
        }

        if (EMPTY_STRING.equals(delimiter)) {
            return null;
        }

        return str.split(delimiter);
    }
}
