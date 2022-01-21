package racingcar;

import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.utils.OutputView;
import racingcar.utils.Randoms;

public class Game {

    private final Cars cars;
    private final int RANDOM_BOUND = 10;

    public Game(Cars cars) {
        this.cars = cars;
    }

    public void play() {
        for (Car car: cars.get()) {
            int random = Randoms.getRandomIntWithinRange(RANDOM_BOUND);
            if (Randoms.moveAvailable(random))
                car.run();
            OutputView.printDistance(car);
        }
        System.out.println();
    }

    public String winners() {
        return cars.filterWinners().stream()
            .map(Car::name)
            .collect(Collectors.joining(", "));
    }
}
