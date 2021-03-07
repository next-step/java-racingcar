package study.step2;

public class StringValidator {
    public static final String SPLIT_DELIMITER=" ";
    private static final String NUMBER_CHECK_REGEX="^[0-9]+$";

    public static boolean isBlank(String input){
        return (input == null || input.trim().isEmpty());
    }

    public static boolean checkNumberSyntax(String input){
        return input.matches(NUMBER_CHECK_REGEX);
    }
}
