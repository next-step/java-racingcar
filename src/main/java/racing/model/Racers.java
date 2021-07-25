package racing.model;

import racing.strategy.ForwardConditionStrategy;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.List.copyOf;
import static java.util.stream.IntStream.range;

public class Racers<T extends Racer> {
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

    public void turnAround(ForwardConditionStrategy strategy, List<Racers> resultList) {
        range(0, size()).forEach(i -> turnAround(strategy, i));
        resultList.add(from(copyOf(racers.stream().map(it -> Car.deepCopy((Car) it)).collect(Collectors.toList()))));
    }

    private void turnAround(ForwardConditionStrategy strategy, int i) {
        if (strategy.judgeCondition()) {
            return;
        }
        get(i).go();
    }

    public String winner() {
        int max = racers.stream()
                        .map(it -> (Car) it)
                        .max(Car::compareTo)
                        .get().position();

        return racers.stream()
                     .filter(car -> car.position() == max)
                     .map(it -> (Car) it)
                     .map(car -> car.name())
                     .collect(Collectors.joining(", "));
    }
}
