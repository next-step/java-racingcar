package calculator;

public class StringCalculator {

    public Elements splitWithSpace(String input) {
        if (input == null || input.isEmpty())
            throw new IllegalArgumentException("입력 값은 null 이거나 빈 공백 문자가 올 수 없습니다.");
        return new Elements(input.split(" "));
    }

    public int calculate(Elements elements) {
        return elements.calculate();
    }

    public int calculate(String input) {
        return splitWithSpace(input).calculate();
    }
}
