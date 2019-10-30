package project.game;

import java.util.Arrays;
import java.util.List;

public class StringUtils {

    public static List<String> splitStringToList(String string, String regex) {
        return Arrays.asList(string.split(regex));
    }
}
