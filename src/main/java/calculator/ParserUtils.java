package calculator;

import java.util.Optional;

public class ParserUtils {

    private static final String WHITESPACE = " ";

    public static int getNumber(String[] words, int index) {

        if (hasSize(words, index) && isNumber(words, index)) {
            throw new IllegalArgumentException("입력 문자 열이 잘못되었습니다.");
        }
        return Integer.parseInt(words[index]);
    }

    public static String[] toArray(String input) {
        return Optional.ofNullable(input)
                .filter(text -> !text.trim().isEmpty())
                .map(text -> text.split(WHITESPACE))
                .filter(array -> array.length % 2 != 0)
                .orElseThrow(IllegalArgumentException::new);
    }

    private static boolean hasSize(String[] words, int index) {
        return words.length < index + 1;
    }

    private static boolean isNumber(String[] words, int index) {
        return !words[index].matches("^[0-9]+$");
    }

}
