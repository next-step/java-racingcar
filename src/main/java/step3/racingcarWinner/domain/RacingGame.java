package step3.racingcarWinner.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingGame {

    private static final int DEFAULT_CAR_LOCATION = 0;
    private static final int RANDOM_BOUND = 10;
    private static final int MOVE_MIN_VALUE = 4;
    private static final String SPLIT_REGX = ",";
    private int maxPosition;
    private List<Car> carList;

    public RacingGame(String inputName) {
        readyOnCarTrack(inputName);
    }

    private void readyOnCarTrack(String inputName) {
        String[] carNameArr = parseCarNameArr(inputName);
        this.carList = createCarList(carNameArr);
    }

    public List<Car> run() {
        for (Car car : this.carList) {
            moveCar(car);
        }
        return this.carList;
    }

    public String[] parseCarNameArr(String inputName) {
        return inputName.split(SPLIT_REGX);
    }

    public boolean isMove(int arg) {
        if (arg >= MOVE_MIN_VALUE) {
            return true;
        }
        return false;
    }

    private int getRandomNo() {
        Random random = new Random();
        return random.nextInt(RANDOM_BOUND);
    }

    public void prizeCheck(List<List<Car>> lapPerCarList, int racingLap) {
        if (lapPerCarList.size() == racingLap) {
            prize(lapPerCarList.get(lapPerCarList.size() - 1));
        }
    }

    public List<Car> prize(List<Car> carList) {
        for (Car car : carList) {
            prizePerCar(car);
        }
        return carList;
    }

    private void prizePerCar(Car car) {
        if (isWinner(car)) {
            car.prizeWinner();
        }
    }

    private boolean isWinner(Car car) {
        return car.isEqualPosition(maxPosition);
    }

    private void moveCar(Car car) {
        if (isMove(getRandomNo())) {
            car.move();
        }
        if (maxPosition < car.getPosition()) {
            maxPosition = car.getPosition();
        }
    }

    public List<Car> createCarList(String[] carNameArr) {
        List<Car> carList = new ArrayList<>();
        for (String carName : carNameArr) {
            carList.add(new Car(carName, DEFAULT_CAR_LOCATION));
        }
        return carList;
    }

}
