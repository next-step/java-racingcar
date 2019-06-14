package calculator;

public class Calculator {

    public int add(String input) {
        String[] result = input.split("\\s");
        int firstValue = Integer.parseUnsignedInt(result[0]);
        int secondValue = Integer.parseUnsignedInt(result[2]);
        return firstValue + secondValue;
    }
}
