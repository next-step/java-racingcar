package study;

public class StringValidator {
    public static final String SPLIT_DELIMITER=" ";

    public static boolean isBlank(String input){
        return (input == null || input.trim().isEmpty());
    }
}
