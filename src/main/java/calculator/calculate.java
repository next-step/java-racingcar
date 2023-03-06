package calculator;

public class calculate {
    public static int add(int a, int b) {  // public static ?
        return a + b;
    }

    public static int subtract(int a, int b) {
        return a - b;
    }

    public static int multiply(int a, int b) {
        return a * b;
    }

    public static int divide(int a, int b) {
        try {
            return a / b;
        } catch (Exception e) {
            System.out.println(" 0 으로 나눌 수 없습니다");
        }
        return 0;
    }

    public static int IntCalculator(int first, int operator, int second) {
        try {
            if (operator == '+')
                return add(first, second);

            if (operator == '-')
                return subtract(first, second);

            if (operator == '*')
                return multiply(first, second);

            if (operator == '/')
                return divide(first, second);
        } catch (IllegalArgumentException e) {
            System.out.println("올바른 연산기호를 입력하세요");
        }
        return 0;

    }

    static public String[] seperate(String InputStringtext) {
        return InputStringtext.split(" ");
    }

    static public int switchInt(String InputSeperatedArraytext) {
        return Integer.parseInt(InputSeperatedArraytext);
    }

    static public int StringCalculator(String InputStringtext) {
        String [] InputArraytext = calculate.seperate(InputStringtext);
        int result = switchInt(InputArraytext[0]);
        for(int i = 0; i < InputArraytext.length -2; i += 2) {
            result = IntCalculator(result, InputArraytext[i+1].charAt(0), switchInt(InputArraytext[i+2]));
        }
        return result;
    }

}
