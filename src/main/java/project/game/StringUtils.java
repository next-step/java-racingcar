package project.game;

import java.util.Arrays;
import java.util.List;

public class StringUtils {

    public static List<String> splitStringToList(String string, String regex) {
        return Arrays.asList(string.split(regex));
    }
    
    public static String createRepeatedCharacter(int count, char character) {
        StringBuilder positionTextBuilder = new StringBuilder();

        for (int i = 0; i < count; i++) {
            positionTextBuilder.append(character);
        }

        return positionTextBuilder.toString();
    }
}
