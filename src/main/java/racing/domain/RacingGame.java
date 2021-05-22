package racing.domain;

import racing.view.ResultView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class RacingGame {
    static final int NAME_LENGTH = 5;
    static final int MOVE_NUMBER = 4;
    static final int MAX_RANDOM = 10;
    static final String CAR_NAME_SPLIT = ",";
    static Random random = new Random();

    private List<Car> cars;
    private List<List<Car>> roundCars = new ArrayList<>();
    private int tryNo;

    public RacingGame(String carNames, int tryNo) {
        List<Car> cars = getCars(getCarName(carNames));
        this.cars = cars;
        this.tryNo = tryNo;
    }

    private List<Car> getCars(String[] carNames) {
        List<Car> cars = new ArrayList<Car>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        return cars;
    }

    public String[] getCarName(String carNamesStr) {
        String[] carNames = carNamesStr.split(CAR_NAME_SPLIT);
        for (String carName : carNames) {
            if (carName.length() > NAME_LENGTH) {
                throw new IllegalArgumentException("이름은 5자 이내로 .");
            }
        }
        return carNames;
    }

    public void race() {
        List<Car> newCars = new ArrayList<>();
        for (Car car : cars) {
            newCars.add(getRandomMove(random.nextInt(MAX_RANDOM), car));
        }
        this.roundCars.add(newCars);
        this.cars = newCars;
    }


    public Car getRandomMove(int random, Car car) {
        if (random > MOVE_NUMBER) {
            return car.moved();
        }
        return car;
    }

    public List<List<Car>> getRoundCars() {
        return roundCars;
    }

    public boolean isEnd() {
        tryNo--;
        if (tryNo < 0) {
            return true;
        }
        return false;
    }

    public List<String> getWinners() {
        Winners winners = new Winners(cars);
        return winners.winners();
    }
}
