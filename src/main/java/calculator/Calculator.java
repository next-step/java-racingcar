package calculator;

public class Calculator {

    private static final String BLANK = " ";
    private static final String ERROR = "ERROR";

    public static void execute() {
        System.out.println("수식을 입력하시오: ");
        String expression = GetInput.inputString();
        expression = expression.replace(BLANK, "");
        if (expression.length() == 0) {
            throw new IllegalArgumentException("Error: need right expression");
        }
        String[] expressionArray = GetInput.parsing(expression);
        Calculator calculator = new Calculator();
        calculator.calculate(expressionArray);
        return;
    }

    public static void calculate(String[] stringArray) {
        final int LENGTH = (stringArray.length - 1) / 2;
        for (int i = 0; i < LENGTH; i++) {
            if (ERROR.equals(stringArray[0])) {
                System.out.println("ERROR: 종료합니다");
                return;
            }
            if (stringArray[i * 2 + 1] == null) {
                System.out.println("정답: " + Integer.parseInt(stringArray[i * 2]));
                return;    //정수로 바꿔서 리턴
            }
            parseOperation(stringArray, i * 2);
        }
    }

    public static void parseOperation(String[] stringArray, int start) {
        int firstOperand, secondOperand;

        if (ERROR.equals(stringArray[start]) || ERROR.equals(stringArray[start + 2])) {
            stringArray[0] = ERROR;
            return;
        }

        String operator = stringArray[start + 1];
        firstOperand = Integer.parseInt(stringArray[start]);
        secondOperand = Integer.parseInt(stringArray[start + 2]);

        int result = 0;
        if (operator.equals("+")) {
            result = add(firstOperand, secondOperand);
        } else if (operator.equals("-")) {
            result = sub(firstOperand, secondOperand);
        } else if (operator.equals("*")) {
            result = mul(firstOperand, secondOperand);
        } else if (operator.equals("/")) {
            if (secondOperand == 0) {
                stringArray[0] = ERROR;
                return;
            } else {
                result = div(firstOperand, secondOperand);
            }
        } else {
            throw new IllegalArgumentException("Error: need right operator");
        }

        stringArray[start + 2] = String.valueOf(result);
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
