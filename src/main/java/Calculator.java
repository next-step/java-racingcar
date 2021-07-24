import com.sun.org.apache.bcel.internal.generic.SWITCH;

import static com.sun.tools.doclint.Entity.minus;

public class Calculator {

    public static final String ADD = "+";
    public static final String MINUS = "-";
    public static final String DIVISION = "/";
    public static final String MULTIPLICATION = "*";

    public static int result = 0;

    private void decide(String inputStr) {

        String[] splitStr = inputStr.split(" ");
        for (int i = 0; i < splitStr.length; i++) {
            int leftInt = Integer.parseInt(splitStr[i - 1]);
            int rightInt = Integer.parseInt(splitStr[i + 1]);
            switch (splitStr[i]) {
                case ADD:
                    add(leftInt, rightInt);
                    break;
                case MINUS:
                    minus(leftInt, rightInt);
                    break;
                case DIVISION:
                    devision(leftInt, rightInt);
                    break;
                case MULTIPLICATION:
                    mutiplication(leftInt, rightInt);
                    break;
            }

        }
    }

    private void mutiplication(int leftInt, int rightInt) {
        result *= rightInt;
    }

    private void devision(int leftInt, int rightInt) {
        result /= rightInt;
    }

    private void minus(int leftInt, int rightInt) {
        result -= rightInt;
    }

    private void add(int leftInt , int rightInt) {
        result += rightInt;
    }

    public static void main(String[] args) throws Exception {

        byte[] str = new byte[256];
        System.in.read(str, 0, 256);
        String readStr = new String(str);

        Calculator calculator = new Calculator();
        calculator.decide(readStr);



    }
}
