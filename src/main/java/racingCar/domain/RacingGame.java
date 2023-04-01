package racingCar.domain;

import static java.lang.Math.max;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingGame {

    private static final int DRAW_RANGE = 9;
    private String carNames;
    private int tryNumber;
    private int raceTryCount;

    private List<Car> cars;
    private List<String> winners;

    public RacingGame(String carNames) {
        this(carNames, 0);
    }
    public RacingGame(String carNames, int tryNumber) {
        this.carNames = carNames;
        this.tryNumber = tryNumber;
        this.raceTryCount = 0;
        this.cars = new ArrayList<>();
        this.winners = new ArrayList<>();
        initCars(carNames);
    }

    private void initCars(String input) {
        String[] carNameList = input.split(",");

        for (int i = 0; i < carNameList.length; i++) {
            Car car = new Car(carNameList[i]);
            cars.add(car);
        }
    }
    public List<Car> race(List<Car> cars) {
        for (Car car : cars) {
            final int drawNumber = draw();
            car.move(drawNumber);
        }
        int maxPosition = findMaxPosition(cars);
        winners = getWinner(cars, maxPosition);

        raceTryCount++;

        return cars;
    }
    public List<Car> race(List<Car> cars, int tryNumber) {
        // tryNumber 만큼 move
         for (Car car : cars) {
            countOfMove(tryNumber, car);
        }
        raceTryCount += tryNumber;

        return cars;
    }

    private void countOfMove(int tryNumber, Car car) {
        for(int i = 0; i < tryNumber; i++) {
            final int drawNumber = draw();
            car.move(drawNumber);
        }
    }

    public List<String> getWinners() {
        return getWinners(this.cars);
    }

    public List<String> getWinners(List<Car> cars) {
        List<String> winners;
        int maxPosition = findMaxPosition(cars);
        winners = getWinner(cars, maxPosition);
        return winners;
    }

    public List<String> getWinner(List<Car> cars, int maxPosition) {
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            setWinners(maxPosition, winners, car);
        }
        return winners;
    }

    private void setWinners(int maxPosition, List<String> winners, Car car) {
        if (car.getPosition() == maxPosition) {
            winners.add(car.getName());
        }
    }

    private int findMaxPosition(List<Car> cars) {
        int maxPosition = Integer.MIN_VALUE;
        for (Car car : cars) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }
        return maxPosition;
    }

    private int draw() {
        return new Random().nextInt(DRAW_RANGE);
    }

    public List<Car> getCars() {
        return cars;
    }

    public int getTryCount() {
        return raceTryCount;
    }

    public boolean isEnd() {
        if(raceTryCount == tryNumber) {
            return true;
        }
        return false;
    }
}