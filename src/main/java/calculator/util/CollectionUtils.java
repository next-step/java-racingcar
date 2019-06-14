package calculator.util;

import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CollectionUtils {
    public static <E> Stack<E> convertListToStack(List<E> list) {
        Stack<E> stack = new Stack<>();
        stack.addAll(list);

        return stack;
    }

    public static <E> List<E> reverse(List<E> list) {
        return IntStream.range(0, list.size())
                .map(i -> (list.size() - 1 - i))
                .mapToObj(list::get)
                .collect(Collectors.toList());
    }
}
