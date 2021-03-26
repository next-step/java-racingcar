package step3to5.utils;

import java.util.List;
import java.util.stream.Collectors;

public class ConvertToStringFromList {
    public static String convertToStringFromList(List<String> list) {
        String result = list.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
        return result;
    }
}
