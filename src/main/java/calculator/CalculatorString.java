package calculator;

import java.util.Optional;

public class CalculatorString {

    private static final String WHITESPACE = " ";

    public int stringCalculator(String input) {

        CalculatorSymbol calculatorSymbol = new CalculatorSymbol();
        String[] strings = stringParser(input);
        int total = parserInt(strings, 0);

        for (int index = 1; index < strings.length; index += 2) {
            total = calculatorSymbol.findTypeAndCalculator(total, parserInt(strings, index + 1), strings[index]);
        }
        return total;
    }

    public int parserInt(String[] words, int index) {
        String regex = "^[0-9]+$";
        if (words.length < index + 1 || !words[index].matches(regex)) {
            throw new IllegalArgumentException("입력 문자 열이 잘못되었습니다.");
        }
        return Integer.parseInt(words[index]);

    }

    public String[] stringParser(String input) {
        return Optional.ofNullable(input)
                .filter(i -> !i.trim().isEmpty())
                .map(i -> input.split(WHITESPACE))
                .orElseThrow(IllegalArgumentException::new);
    }
}
