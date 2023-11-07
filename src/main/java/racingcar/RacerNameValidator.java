package racingcar;

public class RacerNameValidator {
    private static final String DELIMITER = ",";
    public static final int MAXIMUM_NAME_LENGTH = 5;
    public static String[] splitByComma(String input) {
        String noEmptySpace = replaceAllEmptySpace(input);

        String[] splitedValue = noEmptySpace.split(DELIMITER);

        for(String value : splitedValue) {
            maximumLengthCheck(value);
        }
        return splitedValue;
    }
    public static String replaceAllEmptySpace(String input) {
        return input.replaceAll(" ", "");
    }

    public static void maximumLengthCheck(String value) {
        if(value.length() > MAXIMUM_NAME_LENGTH) {
            throw new IllegalArgumentException("이름은 " + MAXIMUM_NAME_LENGTH + "자를 초과할 수 없습니다.");
        }
    }
}
