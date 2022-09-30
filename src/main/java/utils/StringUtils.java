package utils;

import java.util.List;
import java.util.stream.Collectors;


public class StringUtils {

    private StringUtils() {
        throw new IllegalStateException("Utility class");
    }

    public static boolean isEmpty(String string) {
        return string == null || string.isEmpty();
    }

    public static List<Integer> convertStringListToPositiveIntegerList(List<String> stringList) {
        List<Integer> integerList = convertStringListToIntegerList(stringList);
        integerList.stream().filter(number -> number < 0).findFirst().ifPresent(none -> {
                    throw new NumberFormatException("Negative Number is Invalid");
                }
        );
        return integerList;
    }

    public static List<Integer> convertStringListToIntegerList(List<String> stringList) {
        return stringList.stream().map(Integer::parseInt).collect(Collectors.toList());
    }
}
