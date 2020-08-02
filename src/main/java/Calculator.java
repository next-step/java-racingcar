
public class Calculator {

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
}
