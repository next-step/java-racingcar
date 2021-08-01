package racingCar.domain;

import java.util.ArrayList;
import java.util.List;
import racingCar.ui.PrintService;

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

    public int getCarsArraySize() {
        return cars.size();
    }

    private void generateCars(String[] names) {
        for (String name : names) {
            this.cars.add(new RacingCar(name));
        }
    }

    private void doOneLap() {
        for (RacingCar car : cars) {
            car.goForward(numberGenerator.getNumber());
        }
    }

    private void showCurrentDrivenDistanceWithName() {
        for (RacingCar car : cars) {
            PrintService.printDistanceWithName(car.showDrivenDistance(), car.getCarName());
        }
    }

    public void doFullRace() {
        PrintService.printResultMessage();
        for (int i = 0; i < tryCount; i++) {
            doOneLap();
            PrintService.printEmptyLine();
            showCurrentDrivenDistanceWithName();
        }
        PrintService.printEmptyLine();
        PrintService.printWinners(winnerPolicy.winnerDecision(cars));
    }

}
