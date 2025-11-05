package study;

public class StringCalculator {


    public int isEmptyOrNull(String value) {
        return value == null || value.isEmpty() ? 0:-1;
    }

    public String[] split(String s) {
        return s.split(",");
    }

    public int sum(String[] splitResult) {
        int sum = 0;
        for(String s: splitResult) {
            sum += Integer.parseInt(s);
        }
        return sum;
    }
}
