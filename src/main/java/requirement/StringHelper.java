package requirement;

public class StringHelper {

    public static String[] splitter(String input) {
        if (input.startsWith("(")) {
            input = input.substring(1);
        }
        
        if (input.endsWith(")")) {
            input = input.substring(0, input.length() - 1);
        }

        return input.split(",");
    }

    public static char getCharByIndex(String input, int index) {
        return input.charAt(index);
    }
}
