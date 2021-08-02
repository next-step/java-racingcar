package step2;

public class Calculator {

    public int calculate(String formula) {

        checkInput(formula);

        return calculate(formula.split(" "));
    }

    private void checkInput(String formula) {
        if(formula == null || formula.isEmpty()) {
            throw new IllegalArgumentException("input 값이 없습니다.");
        }
    }

    private int calculate(String[] terms) {

        int current = Integer.parseInt(terms[0]); // 왼쪽 항

        for(int i = 1; i < terms.length; i ++) {
            switch (terms[i]) {
                case "+" :
                    current = add(current, Integer.parseInt(terms[i + 1]));
                    break;
                case "-" :
                    current = subtract(current, Integer.parseInt(terms[i + 1]));
                    break;
                case "*" :
                    current = multiply(current, Integer.parseInt(terms[i + 1]));
                    break;
                case "/" :
                    current = divide(current, Integer.parseInt(terms[i + 1]));
                    break;
                default :
                    throw new IllegalArgumentException("+, -, *, / 외에 다른 문자가 입력 되었습니다.");
            }

            i ++;
        }

        return current;
    }

    private int add(int a, int b) {
        return a + b;
    }

    private int subtract(int a, int b) {
        return a - b;
    }

    private int multiply(int a, int b) {
        return a * b;
    }

    private int divide(int a, int b) {
        return a / b;
    }
}
