package calculator;

import java.util.Optional;

public class ParserUtils {

    private static final String WHITESPACE = " ";

    public static int stringConvertNumber(String word) {

        if (!word.matches("^[0-9]+$")) {
            throw new IllegalArgumentException("입력 문자가 숫자가 아닙니다.");
        }
        return Integer.parseInt(word);
    }

    public static String[] toArray(String input) {
        return Optional.ofNullable(input)
                .filter(text -> !text.trim().isEmpty())
                .map(text -> text.split(WHITESPACE))
                .orElseThrow(IllegalArgumentException::new);
    }

    public static void checkArraySize(String[] InputList) {
        Optional.ofNullable(InputList).filter(list -> list.length % 2 != 0)
                .filter(list -> list.length > 2)
                .orElseThrow(() -> new IllegalArgumentException("리스트 사이즈 오류"));

    }
}
