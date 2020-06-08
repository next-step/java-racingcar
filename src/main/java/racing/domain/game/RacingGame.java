package racing.domain.game;

import racing.domain.car.Car;
import racing.domain.car.CarForwardBehavior;
import racing.domain.car.RacingCars;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
    private final RacingCars racingCars;

    public RacingGame(RacingCars racingCars) {
        this.racingCars = racingCars;
    }

    public List<RacingCars> race(int times) {
        List<RacingCars> racingCarsList = new ArrayList<>();
        for (int i = 0; i < times; i++) {
            racingCars.moveCars(new CarForwardBehavior());
            racingCarsList.add(racingCars);
        }
        return racingCarsList;
    }

    public static int findMaxPosition(RacingCars racingCars) {
        return racingCars.getCars()
                .stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElseThrow(() -> new IllegalArgumentException());
    }

    public static List<String> findWinnersCars(RacingCars racingCars, int maxCarPosition) {
        return racingCars.getCars()
                .stream()
                .filter(list -> list.getPosition() == maxCarPosition)
                .map(list -> list.getCarName())
                .collect(Collectors.toList());
    }

    public RacingCars getRacingCars() {
        return racingCars;
    }

}
