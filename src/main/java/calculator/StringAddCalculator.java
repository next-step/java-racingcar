package calculator;

class StringAddCalculator {

    public static int run(String str) {
        if (str == null || str.isEmpty()) {
            return 0;
        }
        return Integer.parseInt(str);
    }
}
