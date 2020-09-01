package step3.operation;

public class ValidationUtils {

    public static final int NAME_SIZE = 5;

    public static boolean validationName(String name) {
        if(StringUtils.isBlank(name)) {
            return false;
        }
        if(name.length() > NAME_SIZE) {
            return false;
        }
        return true;
    }
}
