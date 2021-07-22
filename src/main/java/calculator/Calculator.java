package calculator;

public class Calculator {

    public int add(String input) {
        String[] inputs = input.split(" ");
        return toInt(inputs[0]) + toInt(inputs[2]);
    }

    private int toInt(String input) {
        return Integer.parseInt(input);
    }
}
