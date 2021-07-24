package study.step2;

public class Calc {

    int result;
    String operator;
    int leftNum;
    int rightNum;


    public Calc(String operator, int leftNum, int rightNum) {
        result = 0;
        this.operator = operator;
        this.leftNum = leftNum;
        this.rightNum = rightNum;
    }

    int calc() {
        if (operator.equals("+")) {
            result = leftNum + rightNum;
        } else if (operator.equals("-")) {
            result = leftNum - rightNum;
        } else if (operator.equals("/")) {
            result = leftNum / rightNum;
        } else if (operator.equals("*")) {
            result = leftNum * rightNum;
        }

        return result;
    }
}
