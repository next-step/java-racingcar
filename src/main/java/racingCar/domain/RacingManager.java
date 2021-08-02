package racingCar.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingManager {

    private final List<RacingCar> cars = new ArrayList<>();
    private final NumberGenerator numberGenerator;
    private final WinnerPolicy winnerPolicy;
    private final int tryCount;

    public RacingManager(String[] names, int tryCount) {
        this.tryCount = tryCount;
        numberGenerator = new RandomNumberGenerator();
        winnerPolicy = new WinnerPolicyImpl();
        generateCars(names);
    }

    public List<RacingCar> getCars() {
        return cars;
    }

    public int getTryCount() {
        return tryCount;
    }

    public int getCarsArraySize() {
        return cars.size();
    }

    private void generateCars(String[] names) {
        for (String name : names) {
            this.cars.add(new RacingCar(name));
        }
    }

    public void doOneLap() {
        for (RacingCar car : cars) {
            car.goForward(numberGenerator.getNumber());
        }
    }

    public List<RacingCar> getWinner(){
        return winnerPolicy.winnerDecision(cars);
    }
}
