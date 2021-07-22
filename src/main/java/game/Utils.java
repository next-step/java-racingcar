package game;

public class Utils {

    public int stringLength(String value) {
        return value.length();
    }

    public String[] stringToStringArray(String value) {
        return value.split(",");
    }

    public String stringByTrim(String value) {
        return value.trim();
    }
}
