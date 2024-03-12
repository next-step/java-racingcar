package step2;

public class StringSumCalculator {
    public static String[] splitWithCommmaAndColon(String value) {
        return value.split("[,|:]");
    }

    public static int emptyReturnZero(String value) {
        if(value.isEmpty()){
            return 0;
        }
        return 0;
    }

    public static int parseStringToInt(String value) {
        return Integer.parseInt(value);
    }

    public static int sum(int[] valueArray) {
        int result = 0;
        for (int value : valueArray) {
            result += value;
        }
        return result;
    }

    public static String getCustomDelimiter(String value) {
        int start = value.indexOf("//") + 2;
        int end = value.indexOf("\n", start);
        return value.substring(start, end);
    }

    public static void checkInputAvailable(String value) {
        if (!value.matches("\\d+")) {
            throw new RuntimeException();
        }
    }
}
