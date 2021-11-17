package racingcar.common.util;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class OutputUtils {
    private OutputUtils() {}
    
    public static String convertLiteral(int position) {
        return IntStream.range(0, position).boxed().map(e -> "-").collect(Collectors.joining());
    }
}
