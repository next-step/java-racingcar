package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingCars {
    private static final Random RANDOM = new Random();
    private static final int BOUND = 10;
    private static final int FIRST = 0;
    List<RacingCar> cars;

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
        List<RacingCar> winnerCars = calculateScores();
        return selectWinners(winnerCars).toString();
    }

    private List<RacingCar> calculateScores() {
        List<RacingCar> winnerCars = new ArrayList<>();
        cars.sort(RacingCar::compareTo);
        RacingCar highScoreCar = cars.get(FIRST);
        for (RacingCar car : cars) {
            winnerCars = car.compareHighScoreCar(highScoreCar, winnerCars);
        }
        return winnerCars;
    }

    private StringBuilder selectWinners(List<RacingCar> winnerCars) {
        StringBuilder winners = new StringBuilder();
        for (RacingCar car : winnerCars) {
            winners.append(car.getName()).append(" ");
        }
        return winners;
    }
}
