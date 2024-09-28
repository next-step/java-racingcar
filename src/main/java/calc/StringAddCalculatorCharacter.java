package calc;

public enum StringAddCalculatorCharacter {
    REGEX(",|:"),PATTERN("//(.)\n(.*)");

    private final String text;

    StringAddCalculatorCharacter(String text) {
        this.text = text;
    }

    public String getText() {
        return this.text;
    }
}
