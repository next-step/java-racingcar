package racing;

import java.util.Optional;

public class ParserUtils {

    private static final String COMMA = ",";

    public static String[] stringToArray(String input) {
        return Optional.ofNullable(input)
                .filter(text -> !text.trim().isEmpty())
                .map(text -> text.split(COMMA))
                .orElseThrow(IllegalArgumentException::new);
    }

    public static void checkBlank(String[] nameList) {
        for (String name : nameList) {
            isBlank(name);
        }
    }

    private static void isBlank(String inputName) {
        if (inputName.isEmpty()) {
            throw new IllegalArgumentException("입력문자에 공백이 있습니다.");
        }
    }


}
