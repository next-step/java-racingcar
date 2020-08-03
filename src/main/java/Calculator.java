import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Calculator {

    Deque<String> inputList;
    String[] calcSet;

    public Calculator() {
        inputList = new LinkedList<>();
        calcSet = new String[3];
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
        if (operator.equals("+"))
            return add(value1, value2);
        if (operator.equals("-"))
            return sub(value1, value2);
        if (operator.equals("*"))
            return multiply(value1, value2);
        if (operator.equals("/"))
            return divide(value1, value2);

        throw new IllegalArgumentException();
    }

    // string 결과값만 받아서 계산
    // 좀더 간단하게 구현하는 방법이 있지 않을까 싶은데..
    public int totalCalculate(String value) {
        int result;
        isNullOrBlank(value);
        String[] splitList = value.split(" ");
        inputList.addAll(Arrays.asList(splitList));
        while (inputList.size() != 1) {
            calcSet[0] = inputList.pop();
            calcSet[1] = inputList.pop();
            calcSet[2] = inputList.pop();
            result = calculate(calcSet[0], calcSet[1], calcSet[2]);
            inputList.addFirst(String.valueOf(result));
        }
        return Integer.parseInt(inputList.pop());
    }

    // Null 값에 대한 Exception 낼 부분 확인
    public void isNullOrBlank(String value) {
        if (value.equals("") || value.equals(" ")) {
            throw new IllegalArgumentException();
        }
    }
}
