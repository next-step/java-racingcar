package calculator;

public class InputReader {
    public String[] separate(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("null is not allowed");
        }
        return input.split(" ");
    }
}
