public class StringAddCalculator {

    public static int splitAndSum(String val) {
        if (isInvalidValue(val)) {
            return 0;
        }
        if (isContainDelimiter(val)) {
            return splitByDelimiterAndSum(val);
        }
        return Integer.parseInt(val);
    }

    private static boolean isInvalidValue(String val) {
        if (val == null || val == "") {
            return true;
        }
        return false;
    }

    private static boolean isContainDelimiter(String val) {
        return val.contains(",") || val.contains(";");
    }

    private static int splitByDelimiterAndSum(String val) {
        int result = 0;
        String[] split = val.split(",|:");
        for (String string : split) {
            result += Integer.parseInt(string);
        }
        return result;
    }



}
