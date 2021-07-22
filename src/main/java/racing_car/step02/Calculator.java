package racing_car.step02;

public class Calculator {
    int result;
    private String operator[] = {"+", "-", "*", "/"};
    private String[] strArray;
    private Validation validation = new Validation();

    public int calculate(String input) {
        validation.nullCheck(input);
        strArray = input.split(" ");
        return execute(strArray);
    }

    public int execute(String str[]) {
        int first = Integer.parseInt(str[0]);
        result = first;
        int numberIndex = 2;
        for (int i = 1; i < str.length; i += numberIndex) {
            String op = str[i];
            if (validation.arithmeticSymbolsCheck(op)) {
                throw new IllegalArgumentException("사칙 연산 기호가 아닙니다.");
            }
            int second = Integer.parseInt(str[i + 1]);
            result = operation(result, op, second);
        }
        return result;
    }

    public int operation(int first, String operator, int second) {
        if (operator.equals("+")) return result = add(first, second);
        if (operator.equals("-")) return result = subtract(first, second);
        if (operator.equals("*")) return result = multiply(first, second);
        if (operator.equals("/")) return result = divide(first, second);

        return result;
    }

    public int add(int first, int second) {
        return first + second;
    }

    public int subtract(int first, int second) {
        return first - second;
    }

    public int multiply(int first, int second) {
        return first * second;
    }

    public int divide(int first, int second) {
        return first / second;
    }
}
