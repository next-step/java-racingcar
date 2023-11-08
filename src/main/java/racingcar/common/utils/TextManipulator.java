package racingcar.common.utils;

public class TextManipulator {

    private static final String COMMA_DELIMITER = ",";
    private static final String EMPTY_TEXT_REGAX = "\\s";

    private TextManipulator(){

    }

    public static String[] splitTextByComma(String text) {
        return text.replaceAll(EMPTY_TEXT_REGAX, "").split(COMMA_DELIMITER);
    }

    public static String joinTextWithComma(String[] texts){
        return String.join(", ", texts);

    }

}
