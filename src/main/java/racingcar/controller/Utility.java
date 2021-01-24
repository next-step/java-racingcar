package racingcar.controller;

import java.util.ArrayList;
import java.util.Arrays;

public class Utility {

    public static ArrayList<String> convertNameStringToArray(String nameString) {
        nameString = removeEmptySpaceFromName(nameString);
        return new ArrayList<String>(Arrays.asList(nameString.split(",")));
    }

    private static String removeEmptySpaceFromName(String nameString) {
        return nameString.replace(" ", "");
    }
}
