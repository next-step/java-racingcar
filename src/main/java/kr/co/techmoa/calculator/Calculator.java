import java.util.Scanner;

public class Calculator {

    public static final String ADD = "+";
    public static final String MINUS = "-";
    public static final String DIVISION = "/";
    public static final String MULTIPLICATION = "*";

    public static final String EMPTY = " ";
    public static final int ZERO = 0;

    public static int result = 0;

    public int judge(String inputStr) {

        Vaildator.vaildateInit(inputStr);

        String[] splitStr = inputStr.split(EMPTY);
        result = Integer.parseInt(splitStr[0]);

        for (int i = 0; i < splitStr.length; i++) {
            if(!Util.isNumeric(splitStr[i])) {
                int rightInt = Integer.parseInt(splitStr[i + 1]);
                switch (splitStr[i]) {
                    case ADD:
                        add(rightInt);
                        break;
                    case MINUS:
                        minus(rightInt);
                        break;
                    case DIVISION:
                        devision(rightInt);
                        break;
                    case MULTIPLICATION:
                        mutiplication(rightInt);
                        break;
                    default:
                        throw new IllegalArgumentException("사칙연산 문자가 아닙니다");
                }
            }
        }
        return result;
    }

    public int getResult() {
        return result;
    }

    private void mutiplication(int rightInt) {
        result *= rightInt;
    }

    private int devision(int rightInt) {
        if(ZERO == rightInt) {
            throw new IllegalArgumentException("0 으로 나눌수 없습니다.");
        }
        return result /= rightInt;
    }

    private int minus(int rightInt) {
        return result -= rightInt;
    }

    private int add(int rightInt) {
        return result += rightInt;
    }

    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);

        Calculator calculator = new Calculator();
        System.out.println("결과 : " + calculator.getResult());

    }
}
