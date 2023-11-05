public class StringCalculator {

    private static final String DEFAULT_DELIMETER = ",:";
    private static final String CUSTOME_DELIMETER_END_POINT = "\n";
    public static int cal(String targetOfSplit) {
        if (StringCalculator.isNullOrEmpty(targetOfSplit)) {
            return 0;
        }
        String[] targetOfSum = StringCalculator.split(targetOfSplit);
        return StringCalculator.sum(targetOfSum);
    }

    private static boolean isNullOrEmpty(String targetOfSplit) {
        return targetOfSplit == null || targetOfSplit.isBlank();
    }

    private static String[] split(String targetOfSplit) {
        String finalDelimeter = DEFAULT_DELIMETER;

        if (targetOfSplit.contains(CUSTOME_DELIMETER_END_POINT)) {
            int customDelimeterEndPointIndex = targetOfSplit.indexOf(CUSTOME_DELIMETER_END_POINT);
            char customDelimeter = targetOfSplit.charAt(customDelimeterEndPointIndex - 1);
            finalDelimeter = DEFAULT_DELIMETER + customDelimeter;

            targetOfSplit = targetOfSplit.substring(customDelimeterEndPointIndex + 1);
        }
        return targetOfSplit.split("["+ finalDelimeter +"]");
    }

    private static int sum(String[] split) {
        int sum = 0;
        for (String a : split) {
            int i = Integer.parseInt(a);
            checkNegativeNumber(i);
            sum += i;
        }
        return sum;
    }

    private static void checkNegativeNumber(int i) {
        if (i < 0) {
            throw new RuntimeException();
        }
    }
}
