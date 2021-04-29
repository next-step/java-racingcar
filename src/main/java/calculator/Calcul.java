package calculator;

public class Calcul {

    public int add(int a, int b) {

        return a + b;
    }

    public int sub(int a, int b) {

        return a - b;
    }

    public int multi(int a, int b) {

        return a * b;
    }

    public int division(int a, int b) {

        return a / b;
    }

    public void nullCheck(String input) throws IllegalAccessException {

        if (input == null) {

            throw new IllegalAccessException("입력값이 null입니다.");
        }
    }

    public void operCheck(String input) throws IllegalAccessException {

        if (!input.contains("+") || !input.contains("-") || !input.contains("*") ||
                !input.contains("/")) {

            throw new IllegalAccessException("입력값에 사칙연산이 없습니다.");
        }
    }
}
