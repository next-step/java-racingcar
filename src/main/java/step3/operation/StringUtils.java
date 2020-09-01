package step3.operation;

public class StringUtils {

    public static boolean isBlank(String name) {
        if(name == null) {
            return true;
        }
        if(name.equals(" ")) {
            return true;
        }
        if(name.equals("")) {
            return true;
        }
        return false;
    }
}
