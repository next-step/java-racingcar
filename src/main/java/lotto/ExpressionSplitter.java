package lotto;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class ExpressionSplitter {

    // refineExpression : 커스텀 구분자를 제거한 식
    public static List<String> split(List<String> refineExpression, DelimiterList delimiterList) {
        Iterator<String> iterator = delimiterList.iterator();
        List<String> ret = refineExpression;
        while (iterator.hasNext()) {
            ret = splitExpressionToDelimiter(ret, iterator.next());
        }
        return ret;
    }

    private static List<String> splitExpressionToDelimiter(List<String> expression, String delimiter) {
        return expression
                .stream()
                .map(item -> Arrays.asList(item.split(delimiter)))
                .collect(Collectors.toList())
                .stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }
}
