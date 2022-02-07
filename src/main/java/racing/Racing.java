package racing;

import java.util.List;
import java.util.stream.Collectors;

public class Racing {

    final private int rounds;
    final private Cars cars;

    public Racing(Cars cars, int rounds) {
        this.cars = cars;
        this.rounds = rounds;
    }

    public void race() {
        int roundCount = rounds;
        while (roundCount-- > 0) {
            cars.round();
        }
    }

    public List<String> getWinner() {
        final List<Car> cars = this.cars.getCars();
        cars.sort((a, b) -> b.getDistance() - a.getDistance());
        final int bestScore = cars.get(0).getDistance();
        return cars.stream().filter(car -> car.getDistance() == bestScore)
            .map(car -> car.getName())
            .collect(Collectors.toList());
    }
}
