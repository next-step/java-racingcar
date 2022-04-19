package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingCars {
    private static final Random RANDOM = new Random();
    private static final int BOUND = 10;
    private static final int FIRST = 0;
    private List<RacingCar> cars;

    public RacingCars(String[] carNames) {
        this.cars = new ArrayList<>(carNames.length);
        for (String carName : carNames) {
            cars.add(new RacingCar(carName));
        }
    }

    public List<RacingCar> getCars() {
        return cars;
    }

    public void turnAroundCircuit() {
        for (RacingCar car : cars) {
            car.move(RANDOM.nextInt(BOUND));
        }
    }

    public String award() {
        RacingCar highScoreCar = getHighestScoreCar();
        StringBuilder winners = new StringBuilder();
        for (RacingCar car : cars) {
            winners.append(car.compareWithHighestScoreCar(highScoreCar)).append(" ");
        }
        return winners.toString();
    }

    private RacingCar getHighestScoreCar() {
        cars.sort(RacingCar::compareTo);
        return cars.get(FIRST);
    }
}
