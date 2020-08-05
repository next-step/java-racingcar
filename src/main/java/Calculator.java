import java.util.*;

public class Calculator {

    // Magic Number 구현 추가
    public static final String SPACE_BETWEEN_CHARACTER = " ";
    // package-private으로 선언할 필요가 없었던것. 기록
    private Deque<String> inputList;

    public Calculator() {
        inputList = new LinkedList<>();
    }

    public int add(String value1, String value2) {
        return Integer.parseInt(value1) + Integer.parseInt(value2);
    }

    public int sub(String value1, String value2) {
        return Integer.parseInt(value1) - Integer.parseInt(value2);
    }

    public int multiply(String value1, String value2) {
        return Integer.parseInt(value1) * Integer.parseInt(value2);
    }

    public int divide(String value1, String value2) {
        return Integer.parseInt(value1) / Integer.parseInt(value2);
    }

    // calculate 함수 하나로 묶기
    public int calculate(String value1, String operator, String value2) {
        if (operator.equals("+")) {
            return add(value1, value2);
        }
        if (operator.equals("-")) {
            return sub(value1, value2);
        }
        if (operator.equals("*")) {
            return multiply(value1, value2);
        }
        if (operator.equals("/")) {
            return divide(value1, value2);
        }
        throw new IllegalArgumentException();
    }

    // 입력된 String을 실제 계산하는 Method
    public int calculateWithFullString(String value) {
        int result;
        String leftValue;
        String operatorInString;
        String rightValue;

        if (isNullOrBlank(value)) {
            throw new IllegalArgumentException();
        }

        inputList.addAll(
                Arrays.asList(value.split(SPACE_BETWEEN_CHARACTER))
        );
        while (inputList.size() != 1) {
            leftValue = inputList.pop();
            operatorInString = inputList.pop();
            rightValue = inputList.pop();
            result = calculate(leftValue, operatorInString, rightValue);
            inputList.addFirst(String.valueOf(result));
        }
        return Integer.parseInt(inputList.pop());
    }

    // Null 값에 대한 Exception 낼 부분 확인
    public boolean isNullOrBlank(String value) {
        return Objects.isNull(value) || value.trim().isEmpty();
    }
}
