package calculator;

public class Delimiter {
    private String delimiter;

    public Delimiter(String delimiter) {
        this.delimiter = delimiter;
    }

    public String delimiter() {
        return this.delimiter;
    }

    public String[] split(String inputText) {
        return inputText.split(this.delimiter);
    }
}
