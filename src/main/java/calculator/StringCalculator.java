package calculator;

public class StringCalculator {

    public static int calculate(String text) {
        if(isBlank(text)){
            return 0;
        }
        return calculate(splitData(text));
    }

    private static int calculate(String[] values){

        int result = Integer.parseInt(values[0]);
        for (int i = 2; i < values.length; i += 2) {
            String operator = values[i-1];
            result = calculate(result,operator, Integer.parseInt(values[i]));
        }
        return result;
    }

    private static int calculate(int first,String operator, int second) {
        if ("+".equals(operator)) {
            return addition(first, second);
        }
        if ("-".equals(operator)) {
            return subtraction(first, second);
        }
        if ("*".equals(operator)) {
            return multiplication(first, second);
        }
        if ("/".equals(operator)) {
            return division(first, second);
        }

        throw new IllegalArgumentException("입력 값이 올바르지 않습니다.");
    }

    private static String[] splitData(String text) {
        return text.split(" ");
    }

    private static boolean isBlank(String data){
        if(data == null || data.isEmpty() || " ".equals(data)){
            return true;
        }
        return false;
    }

    private static int addition(int first, int second) {
        return first + second;
    }

    private static int subtraction(int first, int second) {
        return first - second;
    }

    private static int multiplication(int first, int second) { return first * second; }

    private static int division(int first, int second) {
        return first / second;
    }

}
