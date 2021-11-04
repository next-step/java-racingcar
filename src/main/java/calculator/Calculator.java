package calculator;

public class Calculator {
    public static int calculate(String text) {
        checkInput(text);
        String[] values = text.split(" ");
        MyNumber first = new MyNumber(values[0]);
        MyNumber second = new MyNumber(values[2]);
        String operator = values[1];
        return calculate(first, operator, second).getNumber();
    }

    private static MyNumber calculate(MyNumber first, String operator, MyNumber second) {
        if (operator.equals("+")) {
            return first.plus(second);
        }
        if (operator.equals("-")) {
            return first.minus(second);
        }
        if (operator.equals("*")) {
            return first.times(second);
        }
        if (operator.equals("/")) {
            return first.devideBy(second);
        }
        throw new IllegalArgumentException("사칙 연산 기호가 아닙니다.");
    }

    private static void checkInput(String text) {
        if(text == null) {
            throw new IllegalArgumentException("입력이 존재하지 않습니다.");
        }
    }

}
