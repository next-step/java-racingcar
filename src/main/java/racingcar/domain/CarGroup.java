package racingcar.domain;

import racingcar.utils.OutputView;
import racingcar.utils.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class CarGroup {

    public static final int RANDOM_MIN_VALUE = 0;
    public static final int RANDOM_MAX_VALUE = 9;

    private final List<Car> cars;

    private CarGroup(List<Car> cars) {
        this.cars = cars;
    }

    public static CarGroup create(Positive carSize) {
        List<Car> carList = new ArrayList<>();

        for (int i = 0; i < carSize.getNumber(); i++) {
            Car car = Car.create();
            carList.add(car);
        }

        return new CarGroup(carList);
    }

    public void moveCarsByTrySize(Positive trySize) {
        for (int i = 0; i < trySize.getNumber(); i++) {
            OutputView.outputText("=====" + (i+1) + "회차======");
            this.moveCars();
        }
        OutputView.outputText("=====종료======");
    }

    private void moveCars() {
        for (Car car : cars) {
            int randomNumber = RandomNumberGenerator.generateRandomNumber(RANDOM_MIN_VALUE, RANDOM_MAX_VALUE);
            car.move(randomNumber);
        }
    }
}
