package camp.nextstep.edu.util;

import camp.nextstep.edu.calculator.OperatorType;

import java.util.List;

public final class ListUtils {
    private ListUtils() {
    }

    public static Integer getForInteger(List<String> strings, int index) {
        AssertUtils.notNull(strings, "'strings' must not be null");

        final String element = strings.get(index);
        return Integer.parseInt(element);
    }

    public static OperatorType getForOperatorType(List<String> strings, int index) {
        AssertUtils.notNull(strings, "'strings' must not be null");

        final String element = strings.get(index);
        return OperatorType.from(element);
    }
}
