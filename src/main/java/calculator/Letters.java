package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Letters {
    private static final String DELIMITER = " ";

    public static List<String> convertStringToStrings(String input){
        return Arrays.stream(input.split(DELIMITER))
                .collect(Collectors.toList());
    }
}
