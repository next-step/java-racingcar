package calculator;

public class StringAddCalculator {

    public static int sum(String str) {
        if (str == null || str.isEmpty()) {
            return 0;
        }

        String[] strArray = str.split("[,:]");
        int sum = 0;
        for (String s : strArray) {
            sum += Integer.parseInt(s);
        }
        return sum;
    }

}
