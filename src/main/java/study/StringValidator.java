package study;

public class StringValidator {
    public static boolean isBlank(String input){
        return (input == null || input.trim().isEmpty());
    }
}
