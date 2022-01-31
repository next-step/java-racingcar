package racing;

import java.util.List;
import java.util.stream.Collectors;

public class Judgement {

    private static final int FIRST_INDEX = 0;
    private final List<Car> cars;
    private final int bestDistance;

    public Judgement(List<Car> cars) {
        this.cars = cars;
        this.bestDistance = getBestScore();
    }

    private int getBestScore() {
        cars.sort(Car::compareTo);
        return cars.get(FIRST_INDEX).getDistance();
    }

    public List<String> judgeWinner() {
        return cars.stream()
            .filter(car -> car.isSameDistance(bestDistance))
            .map(Car::getName)
            .collect(Collectors.toList());
    }
}
