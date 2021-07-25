package study.step2;

public class Calc {

    int result;

    public Calc() {
        this.result = 0;
    }

    int calc(String operator, int leftNum, int rightNum) {
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
