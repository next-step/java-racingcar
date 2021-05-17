package racing.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class RacingGame {
    static final int NAME_LENGTH = 5;
    static final int MOVE_NUMBER = 4;
    static final int MAX_RANDOM = 10;
    static final int WINNER_NUMBER = 0;
    static final String CAR_NAME_SPLIT = ",";
    static Random random = new Random();

    private List<Car> cars;
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
        getMovingRange(cars);
    }

    private void getMovingRange(List<Car> cars) {
        for (Car car : cars) {
            getRandomMove(random.nextInt(MAX_RANDOM), car);
        }
    }

    public Car getRandomMove(int random, Car car) {
        if (random > MOVE_NUMBER) {
            car.moved();
        }
        return car;
    }

    public List<Car> getCars() {
        return cars;
    }

    public boolean isEnd() {
        tryNo--;
        if (tryNo < 0) {
            return true;
        }
        return false;
    }

    public List<String> getWinners() {
        Collections.sort(cars);
        List<String> winner = new ArrayList<>();
        winner.add(cars.get(WINNER_NUMBER).getName());
        for (int i = 1; i < cars.size(); i++) {
            if (cars.get(i).getMovingRange() == cars.get(WINNER_NUMBER).getMovingRange()) {
                winner.add(cars.get(i).getName());
            }
        }
        return winner;
    }

}
