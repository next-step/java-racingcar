package calculator;

import java.util.Optional;

public class ParserUtils {

    private static final String WHITESPACE = " ";

    private ParserUtils() {
    }

    private static ParserUtils parserUtils = null;

    public static ParserUtils getInstance() {

        if (parserUtils == null) {
            parserUtils = new ParserUtils();
        }
        return parserUtils;
    }

    public int getNumber(String[] words, int index) {

        if (hasSize(words, index) && IsNumber(words, index)) {
            throw new IllegalArgumentException("입력 문자 열이 잘못되었습니다.");
        }
        return Integer.parseInt(words[index]);

    }


    public String[] toArray(String input) {
        return Optional.ofNullable(input)
                .filter(text -> !text.trim().isEmpty())
                .map(text -> text.split(WHITESPACE))
                .filter(text -> text.length % 2 != 0)
                .orElseThrow(IllegalArgumentException::new);
    }

    private boolean hasSize(String[] words, int index) {
        return words.length < index + 1;
    }

    private boolean IsNumber(String[] words, int index) {
        return !words[index].matches("^[0-9]+$");
    }

}
