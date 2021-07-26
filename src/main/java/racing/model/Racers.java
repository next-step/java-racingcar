package racing.model;

import racing.strategy.ForwardConditionStrategy;

import java.util.List;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;
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
        List<Car> cars = List.copyOf(racers.stream()
                                           .map(racer -> Car.deepCopy((Car) racer))
                                           .collect(toList()));
        resultList.add(Racers.from(cars));
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
                     .collect(joining(", "));
    }
}
