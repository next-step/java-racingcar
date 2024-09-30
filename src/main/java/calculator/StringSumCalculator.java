package calculator;

public class StringSumCalculator {

    public static int sum(final String text) {
        if(text == null || text.isEmpty()){
            return 0;
        }
        return Integer.parseInt(text);
    }
}
