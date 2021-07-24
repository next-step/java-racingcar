public class Calculator {

    public static final String ADD = "+";
    public static final String MINUS = "-";
    public static final String DIVISION = "/";
    public static final String MULTIPLICATION = "*";

    public static int result = 0;

    public Calculator(String inputStr)  {
        if(inputStr.equals("") || inputStr == null) {
            throw new IllegalArgumentException();
        }
        String[] splitStr = inputStr.split(" ");
        judge(splitStr);
    }

    public int judge(String[] splitStr) {


        for (int i = 0; i < splitStr.length; i++) {
            if(!Util.isNumeric(splitStr[i])) {
                switch (splitStr[i]) {
                    case ADD:
                        result = add(result , Integer.parseInt(splitStr[i + 1]));
                        break;
                    case MINUS:
                        result = minus(result ,Integer.parseInt(splitStr[i + 1]));
                        break;
                    case DIVISION:
                        result = devision(result ,Integer.parseInt(splitStr[i + 1]));
                        break;
                    case MULTIPLICATION:
                        result = mutiplication(result ,Integer.parseInt(splitStr[i + 1]));
                        break;
                    default:
                        throw new IllegalArgumentException();
                }
            }
        }
        return result;
    }

    public int getResult() {
        return result;
    }

    private int mutiplication(int result, int rightInt) {
        return result *= rightInt;
    }

    private int devision(int result, int rightInt) {
        return result /= rightInt;
    }

    private int minus(int result, int rightInt) {
        return result -= rightInt;
    }

    private int add(int result, int rightInt) {
        return result += rightInt;
    }

    public static void main(String[] args) throws Exception {

        byte[] str = new byte[256];
        System.in.read(str, 0, 256);
        String readStr = new String(str);

        Calculator calculator = new Calculator(readStr);
        System.out.println("결과 : " + calculator.getResult());

    }
}
