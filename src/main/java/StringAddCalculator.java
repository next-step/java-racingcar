public class StringAddCalculator {

    public static int splitAndSum(String val) {
        if (isInvalidValue(val)) {
            return 0;
        }
        int result = Integer.parseInt(val);
        return result;
    }

    private static boolean isInvalidValue(String val) {
        if (val == null || val == "") {
            return true;
        }
        return false;
    }




}
