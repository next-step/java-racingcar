package calculator;

public class SplitInfo {

    private String input;
    private String separator;

    public SplitInfo(String input, String separator) {
        this.input = input;
        this.separator = separator;
    }

    public String getInput() {
        return input;
    }

    public String getSeparator() {
        return separator;
    }
}
