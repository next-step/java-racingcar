package calculator;


import java.util.ArrayList;

public class InternalCalculator {

    private static RequestInput requestInput = new RequestInput();

    public int add(int a, int b) {
        return a + b;
    }

    /*
    public int startCalculator() {
        String[] inputArray = requestInput.askUserForSuitableInput();
        //TODO : 받아온 문자열을 연산하는 클래스함수 호출?
        return getTotal();
    }*/

    private int getTotal(ArrayList<CalculationInfo> calculationUserInfo) {
        int total = 0;
        for (int i = 0; i < calculationUserInfo.size(); i++) {
            total += calculate(calculationUserInfo.get(i));
        }
        return total;
    }

    private int calculate(CalculationInfo calculationInfo) {
        Operator operator = calculationInfo.getOperator();
        int dividend = calculationInfo.getDividend();
        int divisor = calculationInfo.getDivisor();
        switch (operator) {
            case ADD:
                return dividend + divisor;
            case SUBTRACT:
                return dividend - divisor;
            case MULTIPLY:
                return dividend * divisor;
            default:
                return dividend / divisor;
        }
    }
}
