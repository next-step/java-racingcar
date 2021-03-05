package calculator;

import operator.Operator;
import operator.OperatorFactory;

public class Calculator {

    public Calculator() {
    }

    public int calculate(String express) {
        if (isBlank(express)) throw new IllegalArgumentException();
        return getResult(splitBlank(express));
    }

    private boolean isBlank(String express) {
        if (express == null) return true;
        if (express.equals(" ")) return true;
        if (express.contains("  ")) return true;
        return false;
    }

    private String[] splitBlank(String express) {
        return express.split(" ");
    }

    private int getResult(String[] data) {
        int sum = 0;
        for (int i = 0; i < data.length - 2; i += 2) {
            // 유효성 검사에서 연산자임을 이미 검증했다 가정하고 코딩을 시작 -> 이부분 아직 미 구현
            Operator operator = getOperatorByOperatorFactory(data[i+1]);
            sum += operator.operate(stringToInt(data[i]), stringToInt(data[i+2]));
        }
        return sum;
    }

    private Operator getOperatorByOperatorFactory(String operator) {
        return OperatorFactory.getOperator(operator).orElseThrow(
                () -> new IllegalArgumentException());
    }

    private int stringToInt(String digitValue) {
        return Integer.parseInt(digitValue);
    }

    // 이후, 정규표현식을 이용해서 검증을 하면 좋다는 생각에 메모용으로 주석 남겨놓았습니다.-> 후에 삭제예정
    // private boolean isPatternMatches(String express){
    // return !(Pattern.matches("^[0-9\\+\\-*/\\s=]*$", express));}

}
