package step1;

public class Number {

    public boolean isOdd(int input) {
        return input % 2 != 0;
    }

    public boolean isBlank(String input) {
        return input == null || input.trim().isEmpty();
    }
}
