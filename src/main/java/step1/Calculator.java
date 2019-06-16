package step1;

public class Calculator {

    public int add(int leftValue, int rightValue){
        return leftValue + rightValue;
    }

    public int subtract(int leftValue, int rightValue) {
        return leftValue - rightValue;
    }

    public int multiple(int leftValue, int rightValue) {
        return leftValue * rightValue;
    }

    public int divide(int leftValue, int rightValue) {
        return leftValue / rightValue;
    }

    public int calculate(String operatorType, int leftValue, String rightValueInString) {

        int rightValue = Integer.parseInt(rightValueInString);

        if("+".equals(operatorType)) return add(leftValue, rightValue);
        if("-".equals(operatorType)) return subtract(leftValue, rightValue);
        if("*".equals(operatorType)) return multiple(leftValue, rightValue);
        if("/".equals(operatorType)) return divide(leftValue, rightValue);

        return -1; //TODO: 질문입니다! 여기서 무엇을 반환해야 할 지 모르겠습니다.
    }

}
