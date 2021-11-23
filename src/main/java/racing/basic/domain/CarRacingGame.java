package racing.basic.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class CarRacingGame {

    private final List<Car> cars;

    public CarRacingGame(int lineCount) {
        cars = Stream.generate(Car::new)
                .limit(lineCount)
                .collect(collectingAndThen(toList(), Collections::unmodifiableList));
    }

    public List<Integer> nextRound(List<Integer> diceNumbers) {
        for (int i = 0; i < cars.size(); i++) {
            Car car = cars.get(i);
            int diceNumber = diceNumbers.get(i);
            car.moveOrStop(diceNumber);
        }
        return displayTrack();
    }

    private List<Integer> displayTrack() {
        return cars.stream()
                .map(Car::getDrivingDistance)
                .collect(Collectors.toList());
    }
}
