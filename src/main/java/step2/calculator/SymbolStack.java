package step2.calculator;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class SymbolStack {
    private final Stack<String> stack;

    public SymbolStack(final List<String> symbols) {
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

    public int size() {
        return stack.size();
    }
}
