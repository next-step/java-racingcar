package step2;

public class Calculator {

    public int addition (int num1, int num2) {
        return num1 + num2;
    }

    public int subtraction (int num1, int num2) {
        return num1 - num2;
    }

    public int multiplication (int num1, int num2) {
        return num1 * num2;
    }

    public int division (int num1, int num2) {
        if (num2 <= 0) {
            throw new ArithmeticException("0으로는 나눌수 없습니다");
        }
        return num1 / num2;
    }

    public void vaildate (String input) {
        if (input.trim().isEmpty() || input == null) {
            throw new IllegalArgumentException("에러");
        }
    }

    public void operatorCheck (String input) {
        if (!"+".equals(input) && !"-".equals(input) && !"*".equals(input) && !"/".equals(input)) {
            throw new IllegalArgumentException("연산기호가 아닙니다");
        }
    }

    public String[] splitCheck (String input) {
        return input.split(" ");
    }

    public int changeResult (String input) {
        String[] st = input.split(" ");
        int result = 0;
        for (int i = 0; i < st.length; i += 2) {
            String op = st[i];
            result = Integer.parseInt(op);
        }
        System.out.println(result);
        return result;
    }

    public void changeString (String input) {
        String[] st = input.split(" ");
        for (int i = 1; i < st.length - 1; i += 2) {
            String operator = st[i];
            System.out.println(operator);
//            result = stringCalculator.calculator(result, operator, Integer.parseInt(strings[i + 1]));
        }
    }
}

