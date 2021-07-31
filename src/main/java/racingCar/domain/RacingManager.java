package racingCar.domain;

import java.util.ArrayList;
import java.util.List;
import racingCar.ui.PrintService;

public class RacingManager {

    private int numberOfCar;
    private int tryCount;
    final private List<RacingCar> cars = new ArrayList<>();
    private final NumberGenerator numberGenerator;
    private final WinnerPolicy winnerPolicy;

    public int getNumberOfCar() {
        return numberOfCar;
    }

    public int getCarsArraySize() {
        return cars.size();
    }

    public RacingManager() {
        this.numberOfCar = 0;
        this.tryCount = 0;
        numberGenerator = new RandomNumberGenerator();
        winnerPolicy = new WinnerPolicyImpl();
        generateCars();
    }

    public RacingManager(int numberOfCar) {
        this.numberOfCar = numberOfCar;
        numberGenerator = new RandomNumberGenerator();
        winnerPolicy = new WinnerPolicyImpl();
        generateCars();
    }

    public RacingManager(String[] names, int tryCount) {
        this.numberOfCar = names.length;
        this.tryCount = tryCount;
        numberGenerator = new RandomNumberGenerator();
        winnerPolicy = new WinnerPolicyImpl();
        generateCars(names);
    }

    private void generateCars() {
        for (int i = 0; i < numberOfCar; i++) {
            this.cars.add(new RacingCar());
        }
    }

    private void generateCars(String[] names) {
        for (int i = 0; i < numberOfCar; i++) {
            this.cars.add(new RacingCar(names[i]));
        }
    }

    private void doOneLap() {
        for (RacingCar car : cars) {
            car.goForward(numberGenerator.getNumber());
        }
    }

    private void showCurrentDrivenDistance() {
        for (RacingCar car : cars) {
            PrintService.printDistance(car.showDrivenDistance());
        }
    }

    private void showCurrentDrivenDistanceWithName() {
        for (RacingCar car : cars) {
            PrintService.printDistanceWithName(car.showDrivenDistance(), car.getCarName());
        }
    }

    public void doFullRace() {
        System.out.println("실행 결과");
        for (int i = 0; i < tryCount; i++) {
            doOneLap();
            PrintService.printEmptyLine();
            showCurrentDrivenDistanceWithName();
        }
        PrintService.printEmptyLine();
        PrintService.printWinners(winnerPolicy.winnerDecision(cars));
    }

}
