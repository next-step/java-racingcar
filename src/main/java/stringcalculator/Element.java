package stringcalculator;

public class Element {
    private final String element;

    public Element(final String value) {
        validate(value);
        this.element = value;
    }

    private void validate(final String value) {
        if (!value.matches("^[0-9]*$")) {
            throw new RuntimeException("0이상 9이하의 숫자만 가능합니다");
        }
    }

    public int toInt() {
        if (element.isBlank()) {
            return 0;
        }

        return Integer.parseInt(element);
    }
}
