package stringcalculator;

public class StringCalculator {
    private final Text text;
    private final Elements elements;

    public StringCalculator(String text) {
        this.text = new Text(text);
        this.elements = new Elements(this.text.parse());
    }

    public int calculate() {
        return elements.sum();
    }
}
