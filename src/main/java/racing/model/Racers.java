package racing.model;

import racing.domain.ForwardConditionStrategy;

import java.util.List;

import static java.util.stream.IntStream.range;

public class Racers<T extends Racer> {
    private static final String NEW_LINE = System.lineSeparator();

    private final List<T> racers;

    private Racers(List<T> racers) {
        this.racers = racers;
    }

    public static Racers from(List<? extends Racer> cars) {
        return new Racers(cars);
    }

    public int size() {
        return this.racers.size();
    }

    public T get(int index) {
        return racers.get(index);
    }

    public void turnAround(ForwardConditionStrategy strategy, StringBuilder stringBuilder) {
        range(0, size()).forEach(index -> turnAround(strategy, stringBuilder, index));
    }

    private void turnAround(ForwardConditionStrategy strategy, StringBuilder stringBuilder, int index) {
        if (strategy.judgeCondition()) {
            stringBuilder.append(get(index).position()).append(NEW_LINE);
            return;
        }
        stringBuilder.append(get(index).go().position()).append(NEW_LINE);
    }
}
