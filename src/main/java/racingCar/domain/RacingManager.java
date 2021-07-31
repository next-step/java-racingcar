package racingCar.domain;

import java.util.ArrayList;
import java.util.List;
import racingCar.ui.PrintService;

public class RacingManager {

    private int numberOfCar;
    private int tryCount;
    final private List<RacingCar> cars = new ArrayList<>();
    private final NumberGenerator numberGenerator;

    public void setNumberOfCar(int numberOfCar) {
        this.numberOfCar = numberOfCar;
    }

    public void setTryCount(int tryCount) {
        this.tryCount = tryCount;
    }

    public int getNumberOfCar() {
        return numberOfCar;
    }

    public int getTryCount() {
        return tryCount;
    }

    public int getCarsArraySize() {
        return cars.size();
    }

    public RacingManager() {
        this.numberOfCar = 0;
        this.tryCount = 0;
        numberGenerator = new RandomNumberGenerator();
        generateCars();
    }

    public RacingManager(int numberOfCar) {
        this.numberOfCar = numberOfCar;
        numberGenerator = new RandomNumberGenerator();
        generateCars();
    }

    public RacingManager(int numberOfCar, int tryCount) {
        this.numberOfCar = numberOfCar;
        this.tryCount = tryCount;
        numberGenerator = new RandomNumberGenerator();
        generateCars();
    }

    public RacingManager(String[] names, int tryCount) {
        this.numberOfCar = names.length;
        this.tryCount = tryCount;
        numberGenerator = new RandomNumberGenerator();
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
    }

}
