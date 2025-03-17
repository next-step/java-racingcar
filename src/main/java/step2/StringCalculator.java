package step2;

public class StringCalculator {


    public static int splitAndSum(String s) {
        if (s == null) {
            return 0;
        }
        if (s.isEmpty()) {
            return 0;
        }
        return Integer.parseInt(s);
    }
}
