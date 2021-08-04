package step5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class RacingCars {

    private final List<RacingCar> racingCars = new ArrayList<>();

    public static RacingCars create(String[] carNames) {
        return new RacingCars(carNames);
    }

    private RacingCars(String[] carNames) {
        setRacingCars(carNames);
    }

    private void setRacingCars(String[] carNames) {
        Arrays.stream(carNames).forEach(carName ->
                this.racingCars.add(RacingCar.create(carName))
        );
    }

    public int size() {
        return this.racingCars.size();
    }

    public void run() {
        for (RacingCar car: racingCars) {
            car.move(new RandomMovable());
        }
    }

    public List<RacingCar> getAll() {
        return racingCars;
    }

    public List<String> getWinners() {
        int winnerStatus = racingCars.stream()
                .map(RacingCar::getStatus)
                .mapToInt(value -> value)
                .max()
                .orElseThrow(NoSuchElementException::new);

        return racingCars.stream()
                .filter(racingCar -> racingCar.getStatus() == winnerStatus)
                .map(RacingCar::getName)
                .collect(Collectors.toList());
    }
}
