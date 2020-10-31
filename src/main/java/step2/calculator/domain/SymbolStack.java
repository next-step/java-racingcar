package step2.calculator.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static common.util.Preconditions.checkArgument;

public class SymbolStack {
    // 모든 연산은 x, y, operation symbol 이 필요함. ex) x + y
    private static final int OPERABLE_MINIMUM_STACK_SIZE = 3;

    private final Stack<String> stack;

    public SymbolStack(final List<String> symbols) {
        checkArgument(Objects.nonNull(symbols) && symbols.size() > 0, "symbols should not empty");
        checkArgument(symbols.size() >= OPERABLE_MINIMUM_STACK_SIZE, "symbols should more than 3");
        this.stack = toStack(symbols);
    }

    private Stack<String> toStack(final List<String> symbols) {
        final Iterator<String> reverseIterator = new LinkedList<>(symbols)
                .descendingIterator();

        return StreamSupport.stream(
                Spliterators.spliteratorUnknownSize(reverseIterator, Spliterator.ORDERED),
                false)
                .collect(Collectors.toCollection(Stack::new));
    }

    public Operation popToOperation() {
        return Operation.symbolOf(stack.pop());
    }

    public Integer popToInt() {
        return Integer.parseInt(stack.pop());
    }

    public void add(final Integer number) {
        stack.add(String.valueOf(number));
    }

    public boolean isOperable() {
        return stack.size() >= OPERABLE_MINIMUM_STACK_SIZE;
    }
}
