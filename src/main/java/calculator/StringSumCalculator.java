package calculator;

public class StringSumCalculator {

    public static int sum(final String text) {
        int result = 0;
        if(text == null || text.isEmpty()){
            return result;
        }
        String[] split = text.split(",");
        for (String s : split) {
            result += Integer.parseInt(s);
        }
        return result;
    }
}
