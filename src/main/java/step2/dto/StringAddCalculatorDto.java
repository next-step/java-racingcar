package step2.dto;

public class StringAddCalculatorDto {
    private String text;
    private String separatorRegex;

    public StringAddCalculatorDto(String text, String separatorRegex) {
        this.text = text;
        this.separatorRegex = separatorRegex;
    }

    public String getText() {
        return text;
    }

    public String getSeparatorRegex() {
        return separatorRegex;
    }
}
