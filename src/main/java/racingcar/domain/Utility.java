package racingcar.domain;

import java.util.ArrayList;
import java.util.Arrays;

public class Utility {
    public static ArrayList<String> nameStringToArray(String nameString) {
        nameString = removeEmptySpaceFromName(nameString);
        return new ArrayList<String>(Arrays.asList(nameString.split(",")));
    }

    private static String removeEmptySpaceFromName(String nameString) {
        return nameString.replace(" ", "");
    }
}
