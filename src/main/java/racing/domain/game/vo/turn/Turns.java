package racing.domain.game.vo.turn;

import racing.exception.InvalidInputException;

import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Turns implements Iterable<Turn> {
    private List<Turn> values;

    private static final int MIN_TURN_SIZE = 1;

    public Turns(List<Turn> values) {
        this.values = values;
    }

    public Turns(int size) {
        validate(size);
        initValues(size);
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

    private Turns filter(Predicate<Turn> filter) {
        return new Turns(values.stream()
                .filter(filter)
                .collect(Collectors.toList())
        );
    }

    public Turns waitingTurns() {
        return filter(Turn::isWaiting);
    }

    public Turns endedTurns() {
        return filter(t -> !t.isWaiting());
    }

    public boolean isEmpty() {
        return values.isEmpty();
    }

    public int size() {
        return values.size();
    }

    @Override
    public Iterator<Turn> iterator() {
        return values.iterator();
    }
}
