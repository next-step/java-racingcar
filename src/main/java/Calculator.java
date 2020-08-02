
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
}
