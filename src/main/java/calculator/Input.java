package calculator;

public class Input {

    private final String text;

    public Input(String text) {
        this.text = text;
    }

    public boolean isEmptyOrNull() {
        return this.text == null || this.text.isBlank();
    }

    public boolean isSingleDigit() {
        return this.text.length() == 1 && Character.isDigit(this.text.charAt(0));
    }

}
