package calculator;

public class Calculator {
    public static int calc(String str) {
        if (isBlank(str)) {
            return 0;
        }
        String[] array = str.split("[,:]");
        return sum(array);
    }

    private static int sum(String[] array) {
        int sum = 0;
        for (String num : array) {
            sum += Integer.parseInt(num);
        }
        return sum;
    }

    public static boolean isBlank(String str) {
        return str == null || str.isBlank();
    }
}
