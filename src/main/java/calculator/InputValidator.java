package calculator;

public class InputValidator {

    public String numberValidate(String inputStr) throws IllegalArgumentException {
        if (inputStr == null || "".equals(inputStr.trim())) throw new IllegalArgumentException();

        return inputStr;
    }

    public String calculateValidate(String inputStr) throws IllegalArgumentException {
        if (!"+".equals(inputStr) && !"-".equals(inputStr) && !"*".equals(inputStr) && !"/".equals(inputStr)) throw new IllegalArgumentException();

        return inputStr;
    }
}
