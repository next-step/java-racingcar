package calculator;

public class Input {

    private String input;

    public Input(String input) {
        this.input = input;
    }

    public boolean isEmptyOrNull() {
        return this.input == null || this.input.isBlank();
    }

    public boolean isSingleDigit() {
        return this.input.length() == 1 && Character.isDigit(this.input.charAt(0));
    }

}
