package stringcalculator;

public class Calculator {

    public void input(String input) {
        if (isNullOrBlank(input)) {
            throw new IllegalArgumentException("입력값이 null이거나 빈 문자열");
        }
    }

    boolean isNullOrBlank(String input){
        return input == null || input.trim().isEmpty();
    }
}
