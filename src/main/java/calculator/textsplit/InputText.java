package calculator.textsplit;

import java.util.List;

public class InputText {
    private final String text;
    private List<String> tokens;

    public InputText(String text) {
        this.text = text;
    }

    public String input() {
        return this.text;
    }

    public void split(String delimiter) {
        tokens = List.of(text.split(delimiter));
    }

    public void split(String text, String delimiter) {
        tokens = List.of(text.split(delimiter));
    }

    public void setTokens(List<String> tokens) {
        this.tokens = tokens;
    }

    public List<String> getTokens() {
        return this.tokens;
    }
}
