package calculator;

public class Calculator {

    private static final String ERROR = "ERROR";

    public static void execute() {
        System.out.println("수식을 입력하시오: ");
        String expression = InputView.inputString();
        String[] expressions = InputView.parsing(expression);
        Calculator calculator = new Calculator();
        calculator.calculate(expressions);
    }

    public static void calculate(String[] strings) {
        final int STRING_ARRAY_LENGTH = (strings.length - 1) / 2;
        for (int i = 0; i < STRING_ARRAY_LENGTH; i++) {
            if (ERROR.equals(strings[0])) {
                System.out.println("ERROR: 종료합니다");
                return;
            }
            if (strings[i * 2 + 1] == null) {
                System.out.println("정답: " + Integer.parseInt(strings[i * 2]));
                return;    //정수로 바꿔서 리턴
            }
            parseOperation(strings, i * 2);
        }
    }

    public static void parseOperation(String[] strings, int start) {
        int firstOperand, secondOperand;

        if (ERROR.equals(strings[start]) || ERROR.equals(strings[start + 2])) {
            strings[0] = ERROR;
            return;
        }

        String operator = strings[start + 1];
        firstOperand = Integer.parseInt(strings[start]);
        secondOperand = Integer.parseInt(strings[start + 2]);

        int result = 0;
        if (operator.equals("+")) {
            result = add(firstOperand, secondOperand);
        } else if (operator.equals("-")) {
            result = sub(firstOperand, secondOperand);
        } else if (operator.equals("*")) {
            result = mul(firstOperand, secondOperand);
        } else if (operator.equals("/")) {
            if (secondOperand == 0) {
                strings[0] = ERROR;
                return;
            } else {
                result = div(firstOperand, secondOperand);
            }
        } else {
            throw new IllegalArgumentException("Error: need right operator");
        }

        strings[start + 2] = String.valueOf(result);
    }

    public static int add(int firstOperand, int secondOperand) {

        return firstOperand + secondOperand;
    }

    public static int sub(int firstOperand, int secondOperand) {

        return firstOperand - secondOperand;
    }

    public static int mul(int firstOperand, int secondOperand) {

        return firstOperand * secondOperand;
    }

    public static int div(int firstOperand, int secondOperand) {

        return firstOperand / secondOperand;
    }
}
