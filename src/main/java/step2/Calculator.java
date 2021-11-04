package step2;

public class Calculator {

    public static int calculate(String input) {
        String[] result = splitTextByRegex(input, " ");

        MyNumber number1 = isValidText(result[0]);
        String operator = result[1];
        MyNumber number2 = isValidText(result[2]);

        return calculate(number1, operator, number2).getNumber();
    }

    public static MyNumber calculateMulti(String input) {
        String[] arr = splitTextByRegex(input, " ");

        int cnt = arr.length;

        MyNumber number = isValidText(arr[0]);

        for(int i = 1 ; i < cnt ; i+=2) {
            String operator = arr[i];
            MyNumber number2 = isValidText(arr[i+1]);

            number = calculate(number, operator, number2);
        }

        return number;
    }

    private static MyNumber calculate(MyNumber number1, String operator, MyNumber number2) {
        if(operator.equals("+")) {
            return number1.plus(number2);
        }
        if(operator.equals("-")) {
            return number1.minus(number2);
        }
        if(operator.equals("*")) {
            return number1.multiply(number2);
        }
        if(operator.equals("/")) {
            return number1.divide(number2);
        }

        throw new IllegalArgumentException("유효하지 않은 사칙연산입니다.");
    }

    private static MyNumber isValidText(String text) {
        if(text.trim().isEmpty() || !text.matches("^[0-9]*$")) {
            throw new IllegalArgumentException("유효하지 않은 숫자입니다.");
        }

        return new MyNumber(text);
    }

    private static String[] splitTextByRegex(String text, String regex) {
        return text.split(regex);
    }
}
