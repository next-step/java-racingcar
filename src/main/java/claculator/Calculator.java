package claculator;

public class Calculator {
    public int addition (int num1, int num2) {
        return Operator.PLUS.caculate(num1, num2);
    }

    public int subtraction (int num1, int num2) {
        return Operator.MINUS.caculate(num1, num2);
    }

    public int multiplication (int num1, int num2) {
        return Operator.MUL.caculate(num1, num2);
    }

    public int division (int num1, int num2) throws ArithmeticException {
        if (num2 <= 0) {
            throw new ArithmeticException("0으로는 나눌수 없습니다");
        }
        return Operator.DIV.caculate(num1, num2);
    }

    public int stringCalculator (String op,int num1,int  num2) {
        if ("+".equals(op)) {
            return Operator.PLUS.caculate(num1, num2);
        }
        if ("-".equals(op)) {
            return Operator.MINUS.caculate(num1, num2);
        }
        if ("*".equals(op)) {
            return Operator.MUL.caculate(num1, num2);
        }
        if ("/".equals(op)) {
            return Operator.DIV.caculate(num1, num2);
        }
        throw new IllegalArgumentException(ErrorMsg.ERROR_CODE_2);
    }
    public void vaildate (String input) {
        if (input.trim().isEmpty() || input == null) {
            throw new IllegalArgumentException(ErrorMsg.ERROR_CODE_1);
        }
    }

    public void operatorCheck (String input) {
        if (!"+".equals(input) && !"-".equals(input) && !"*".equals(input) && !"/".equals(input)) {
            throw new IllegalArgumentException(ErrorMsg.ERROR_CODE_2);
        }
    }

    public String[] splitCheck (String input) {
        return input.split(" ");
    }

    public int changeResult (String input) {
        String[] st = input.split(" ");
        int result = 0;

        for (int i = 0; i < st.length; i += 2) {
            result = Integer.parseInt(st[i]);
        }
        System.out.println(result);
        return result;
    }

    public String changeString (String input) {
        String[] st = input.split(" ");
        String operator = "";
        for (int i = 1; i < st.length - 1; i += 2) {
            operator = st[i];
            System.out.println(operator);
        }
        return operator;
    }

    public int changeAll (String input) {
        String[] st = input.split(" ");
        int result = Integer.parseInt(st[0]);

        for (int i = 1; i < st.length - 1; i += 2) {
            String operator = st[i];
            stringCalculator(operator,result, Integer.parseInt(st[i + 1]));
        }
        return result;
    }
}

