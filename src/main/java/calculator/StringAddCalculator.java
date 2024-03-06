package calculator;

public class StringAddCalculator {
    public static int splitAndSum(String input){
         if(input == null || input.isEmpty()) {
            return 0;
        }
        return calculate(input);
    }
    private static int calculate(String input) {
        int result = 0;
        String[] numbers = split(input);
        for(String number : numbers) {
            result += parseNumber(number);
        }
        return result;
    }
    // 문자열 분리
    public static String[] split(String input) {
        return input.split(",");
    }
    public static int parseNumber(String input){
        return Integer.parseInt(input);
    }
}
