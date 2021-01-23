package racingcar.domain;

import java.util.ArrayList;
import java.util.Arrays;

public class Utility {
    public static ArrayList<String> nameStringToArray(String nameString) {
        return new ArrayList<String>(Arrays.asList(nameString.split(",")));
    }

    public static String removeEmptySpaceFromName(String nameString) {
        return nameString.replace(" ", "");
    }
}
