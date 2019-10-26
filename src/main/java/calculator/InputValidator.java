package calculator;

public class InputValidator {

    public String validate(String inputStr) throws IllegalArgumentException {
        if (inputStr == null || "".equals(inputStr.trim())) throw new IllegalArgumentException("입력한 값을 확인하세요.");

        return inputStr;
    }

    public String calculateValidate(String inputStr) throws IllegalArgumentException {
        if (!"+".equals(inputStr) && !"-".equals(inputStr) && !"*".equals(inputStr) && !"/".equals(inputStr)) throw new IllegalArgumentException("사칙연산 기호를 확인하세요.");

        return inputStr;
    }
}
