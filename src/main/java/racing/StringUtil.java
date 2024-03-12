package racing;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringUtil {

    public static List<String> splitStringToList(String str, String regex) {
        return Arrays.stream(str.split(regex))
                .map(String::trim)
                .collect(Collectors.toList());
    }

    public static void addDelimiterToStringBuilder(StringBuilder stringBuilder, String delimiter) {
        if (stringBuilder.length() > 0) {
            stringBuilder.append(delimiter);
        }
    }
}
