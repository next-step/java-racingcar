package racingGame;

import java.util.Arrays;
import java.util.List;

public class Util {

    public static List<String> stringSplitToList(String input, String regex) {
        return Arrays.asList(input.split(regex));
    }
    public static String joinListString(List<String> input, String regex){
        return String.join(regex, input);

    }
}
