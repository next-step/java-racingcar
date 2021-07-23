package Calculator;

public class StringCalculator {
    private int output;
    private String[] splitedString;
    private int splitedStringSize;

    public int calculate(String s) {
        if(s == null) throw new IllegalArgumentException("null값을 입력받았습니다.");
        String[] splitedString = s.split(" ");
        if(splitedString.length == 0) throw new IllegalArgumentException("빈값을 입력받았습니다.");
        int output = Integer.parseInt(splitedString[0]);
        if(splitedString.length == 1) return output;
        int size = splitedString.length;
        for(int i=1;i<size;i+=2){
            if(i+1 == size) throw new IllegalArgumentException("숫자가 부족합니다.");
            int rightNum = 0;
            try {
                rightNum = Integer.parseInt(splitedString[i+1]);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("숫자가 아닌 수를 입력받았습니다.");
            }
            if(splitedString[i].equals("+")) {
                output += rightNum;
            }
        }

        return output;
    }

    private void validateString(String s) {
        if (s == null || s.trim().isEmpty()) {
            throw new IllegalArgumentException("빈값을 입력받았습니다.");
        }
    }

    private void prepareCalculate(String s) {
        splitedString = s.split(" ");
        output = string2Int(splitedString[0]);
        splitedStringSize = splitedString.length;
    }

    private int getNextNumber(int index) {
        if (index + 1 == splitedStringSize) {
            throw new IllegalArgumentException("숫자가 부족합니다.");
        }

        int rightNum = string2Int(splitedString[index + 1]);
        return rightNum;
    }

    void calculateSplitedString(int index) {
        String operator = splitedString[index];
        int rightNum = getNextNumber(index);

        if(operator.equals(Operator.PLUS.value)){
            plus(rightNum);
            return;
        }

        if(operator.equals(Operator.MINUS.value)){
            minus(rightNum);
            return;
        }

        if(operator.equals(Operator.MULTIPLY.value)){
            multiply(rightNum);
            return;
        }

        if(operator.equals(Operator.DIVIDE.value)){
            divide(rightNum);
            return;
        }

        throw new IllegalArgumentException("사칙연산이 잘 못 되었습니다..");
    }

    private int string2Int(String s){
        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닌 수를 입력받았습니다.");
        }
    }

    private enum Operator {
        PLUS("+"),
        MINUS("-"),
        MULTIPLY("*"),
        DIVIDE("/");

        private final String value;

        Operator(String value) {
            this.value = value;
        }

    }

    private void plus(int rightNum) {
        output = output + rightNum;
    }

    private void minus(int rightNum) {
        output = output - rightNum;
    }

    private void multiply(int rightNum) {
        output = output * rightNum;
    }

    private void divide(int rightNum) {
        output = output / rightNum;
    }
}
