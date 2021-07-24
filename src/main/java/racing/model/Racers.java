package racing.model;

import racing.strategy.ForwardConditionStrategy;

import java.util.List;
import java.util.stream.Collectors;

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
        Car racer = (Car) get(index);

        if (strategy.judgeCondition()) {
            append(stringBuilder, racer);
            return;
        }

        racer.go();

        append(stringBuilder, racer);
    }

    private void append(StringBuilder stringBuilder, Car racer) {
        stringBuilder.append(racer.name())
                     .append(" : ")
                     .append(racer.position())
                     .append(NEW_LINE);
    }

    public String winner() {
        int max = racers.stream()
                        .map(it -> (Car) it)
                        .max(Car::compareTo)
                        .get().position().length();

        return racers.stream()
                     .filter(car -> car.position().length() == max)
                     .map(it -> (Car) it)
                     .map(car -> car.name())
                     .collect(Collectors.joining(", "));
    }
}
