package RacingGame;

import java.util.Arrays;
import java.util.List;

public class Util {

    public static List<String> stringSplitToList(String input, String regex) {
        return Arrays.asList(input.split(regex));
    }
}
