package step2;

public class Calculator {
    private static final String PLUS = "+";
    private static final String MINUS = "-";
    private static final String DIVIDE = "/";
    private static final String MULTIPLY = "*";

    public int operation(String input) {

        String[] inputArg = input.split(" ");

        isEmptyInput(input);

        int leftNum = Integer.valueOf(inputArg[0]);
        for(int i = 1; i < inputArg.length-1; i++) {
            System.out.println(inputArg[i]);
            if(inputArg[i].equals(PLUS)){
                leftNum = plus(leftNum, Integer.valueOf(inputArg[i+1]));
            }
            if(inputArg[i].equals(MINUS)){
                leftNum = minus(leftNum, Integer.valueOf(inputArg[i+1]));
            }
            if(inputArg[i].equals(DIVIDE)){
                leftNum = divide(leftNum, Integer.valueOf(inputArg[i+1]));
            }
            if(inputArg[i].equals(MULTIPLY)){
                leftNum = multiply(leftNum, Integer.valueOf(inputArg[i+1]));
            }
        }
        return leftNum;
    }

    public void isEmptyInput(String input) {
        if(input == null || input.length() == 0)
            throw new IllegalArgumentException("입력 값이 null 이거나 빈 공백 문자일 경우 에러발생");
    }

    public int plus(int input1, int input2) {
        return input1 + input2;
    }

    public int minus(int input1, int input2) {
        return input1 - input2;
    }

    public int divide(int input1, int input2) {
        return input1 / input2;
    }

    public int multiply(int input1, int input2) {
        return input1 * input2;
    }


}
