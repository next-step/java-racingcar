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

    public static void checkEmptyOrBlank(String[] nameList) {
        for (String name : nameList) {
            isEmpty(name);
        }
    }

    private static void isEmpty(String inputName) {
        if (inputName.trim().isEmpty()) {
            throw new IllegalArgumentException("이름이 입력되지 않았습니다.");
        }
    }


}
