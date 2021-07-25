package stringcalculator;

import javafx.util.Pair;

import java.util.Iterator;

public class InputParser implements Iterable<Pair<Operator, Integer>> {
    private final String rawInput;

    public InputParser(String rawInput) {
        this.rawInput = rawInput;
    }

    @Override
    public Iterator<Pair<Operator, Integer>> iterator() {
        return new InputIterator(rawInput);
    }
}
