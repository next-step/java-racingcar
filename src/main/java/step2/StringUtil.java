package step2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StringUtil {

    public static List<String> toEvenIndexList(String text, String separator) {
        List<String> splitText = Arrays.asList(text.split(separator));
        return IntStream.range(0, splitText.size())
                .filter(i -> i % 2 == 0)
                .mapToObj(splitText::get)
                .collect(Collectors.toList());
    }

    public static List<String> toOddIndexList(String text, String separator) {
        List<String> splitText = Arrays.asList(text.split(separator));
        return IntStream.range(0, splitText.size())
                .filter(i -> i % 2 == 1)
                .mapToObj(splitText::get)
                .collect(Collectors.toList());
    }
}
