package calculator;

public class InputValidator {

    public void validate(String inputStr) throws IllegalArgumentException {
        if (inputStr == null || "".equals(inputStr.trim())) throw new IllegalArgumentException();
    }
}
