package step2;

public class Calculator {

    private int num1;
    private int num2;

    public Calculator() {
    }

    public int plus() {
        return num1 + num2;
    }

    public int minus() {
        return num1 - num2;
    }

    public int multiple() {
        return num1 * num2;
    }

    public int divide() {
        return num1 / num2;
    }

    public int calculate(String input){

        nullOrEmptyCheck(input);

        String[] split = input.split(" ");

        int result = Integer.parseInt(split[0]);

        for (int i = 1; i < split.length; i++) {
            String operation = split[i];

            if (isNumber(operation)) {
                continue;
            }

            setNumbers(split[i + 1], result);

            result = Operation.calculate(operation, this);
        }

        return result;
    }

    private void setNumbers(String nextNum, int result) {
        int num = Integer.parseInt(nextNum);

        setCalculatorNumbers(result, num);
    }

    private void setCalculatorNumbers(int num1, int num2){
        this.num1 = num1;
        this.num2 = num2;
    }

    private void nullOrEmptyCheck(String input){
        if (input == null || (input.replaceAll(" ", "").isEmpty())) {
            throw new IllegalArgumentException("입력값이 null 이거나 비어있습니다.");
        }
    }

    private boolean isNumber(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (final NumberFormatException e) {
            return false;
        }
    }
}
