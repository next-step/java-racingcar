package racing.domain.turn;

import racing.exception.InvalidInputException;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Turns implements Iterable<Turn> {
    private List<Turn> values;

    private static final int MIN_TURN_SIZE = 1;

    public Turns(int size) {
        validate(size);
        initValues(size);
    }

    public Turn lastTurn() {
        return values.get(values.size() - 1);
    }

    private void validate(int size) {
        if (size < MIN_TURN_SIZE)
            throw new InvalidInputException("자동차 경주는 1회 이상 이어야 시작 됩니다.");
    }

    private void initValues(int size) {
        values = Stream.generate(Turn::new)
                .limit(size)
                .collect(Collectors.toList());
    }

    public int size() {
        return values.size();
    }

    @Override
    public Iterator<Turn> iterator() {
        return values.iterator();
    }
}
