package study.step2;

public class StringValidator {
    public static final String SPLIT_DELIMITER=" ";
    public static final String CAR_NAME_SPLIT_DELIMITER=",";

    private static final String NUMBER_CHECK_REGEX="^[0-9]+$";

    public static boolean isBlank(String input){
        return (input == null || input.trim().isEmpty());
    }

    public static void checkNumberSyntax(String input){
        if(!input.matches(NUMBER_CHECK_REGEX)) throw new NumberFormatException("숫자를 정확히 입력해주세요");
    }

}
