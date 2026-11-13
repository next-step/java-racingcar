package calculator;

public class StringSumCalculator {
    public static int calculate(String input) {
        if(input == null || input.isEmpty()) {
            return 0;
        }


        String[] split = input.split(",");
        int result = 0;
        for(int i = 0; i < split.length; i++) {
            result += Integer.parseInt(split[i]);
        }
        return result;
    }
}
