package requirement;

public class StringHelper {
    String[] splitter (String input) {
        if(input.startsWith("(")) {
            input = input.substring(1);
        }

        if(input.endsWith(")")) {
            input = input.substring(0, input.length()-1);
        }

        return input.split(",");
    }

    char getCharByIndex (String input, int index) {
        return input.charAt(index);
    }
}
