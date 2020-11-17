package study1.step5;

public class Validator {
    public static boolean inputValidate(String input){
        return (inputNullCheck(input) || inputValueCheck(input));
    }
    public static boolean inputNullCheck(String input){
        return input == null;
    }
    public static boolean inputValueCheck(String input) {
        return "".equals(input.trim());
    }
}
