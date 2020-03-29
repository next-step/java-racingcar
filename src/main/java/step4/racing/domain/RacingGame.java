package step4.racing.domain;

import step4.racing.move.RandomMove;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private RacingInfo racingInfo;
    private List<Car> cars;
    private Car car;
    private RandomMove randomMove = new RandomMove();
    private static final String SEPERATOR = ",";
    private static final String CARS_VALID_MSG = "자동차는 2대 이상 입력해야 합니다.";
    private static final int FIRST_POSITION = 1;


    public RacingGame(RacingInfo racingInfo) {
        this.racingInfo = racingInfo;
        this.cars = new ArrayList<>();
    }

    public void settingCars() {
        String[] carNames = splitCarName(racingInfo.getInputName());

        if (carNames.length < 1) {
            throw new IllegalArgumentException(CARS_VALID_MSG);
        }

        inputCarInfo(carNames);
    }

    public void inputCarInfo(String[] carNames) {
        int carSize = carNames.length;

        for (int i = 0; i < carSize; i++) {
            car = new Car(carNames[i], FIRST_POSITION);
            inputCars(car);
        }
    }

    public void inputCars(Car car) {
        cars.add(car);
    }

    public List<Car> move() {
        for (Car car : cars) {
            movePosition(car);
        }

        return cars;
    }

    private void movePosition(Car car) {
        if (randomMove.isMovable()) {
            car.moveCarPosition();
        }
    }

    public String[] splitCarName(String inputName) {
        return inputName.split(SEPERATOR);
    }

    public List<Car> getCars() {
        return cars;
    }


}
