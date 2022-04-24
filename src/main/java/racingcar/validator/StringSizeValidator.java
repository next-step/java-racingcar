package racingcar.validator;


public class StringSizeValidator implements Validator<String[], String>{

    private static final String DEFAULT_DELIMITER = ",";

    private static final String WRONG_INPUT_ERROR_MESSAGE = "잘못된 입력값 입니다";
    private static final int WRONG_INPUT_LENGTH = 5;

    @Override
    public String[] valid(String input) {
        String[] names = split(input);

        for (String name : names) {
            check(name);
        }

        return names;
    }

    private String[] split(String text) {
        return text.split(DEFAULT_DELIMITER);
    }

    private void check(String name) {
        if (name.length() > WRONG_INPUT_LENGTH) {
            throw new IllegalArgumentException(WRONG_INPUT_ERROR_MESSAGE);
        }
    }

}
