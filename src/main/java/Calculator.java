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
            }
        }

        resultPrint();
    }

    private void resultPrint() {
        System.out.println("결과 : " + result);
    }

    private void mutiplication(int rightInt) {
        result *= rightInt;
    }

    private void devision(int rightInt) {
        result /= rightInt;
    }

    private void minus(int rightInt) {
        result -= rightInt;
    }

    private void add(int rightInt) {
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
