package stringcalculator;

import javafx.util.Pair;

import java.util.Iterator;

public class InputIterator implements Iterator<Pair<Operator, Integer>> {
    private static final String DELIMITER = " ";
    private static final int NEXT_STEP = 2;
    private static final String PLUS_AND_SPACE = "+ ";

    private final String[] splitInput;
    private int index = 0;

    public InputIterator(String rawInput) {
        this.splitInput = withPlusAtHead(rawInput).split(DELIMITER);
    }

    private String withPlusAtHead(String rawInput) {
        return PLUS_AND_SPACE + rawInput;
    }

    @Override
    public boolean hasNext() {
        return index < splitInput.length;
    }

    @Override
    public Pair<Operator, Integer> next() {
        index += NEXT_STEP;
        return new Pair<>(
            OperatorFactory.create(splitInput[index - NEXT_STEP]),
            Integer.parseInt(splitInput[index - NEXT_STEP + 1])
        );
    }
}
