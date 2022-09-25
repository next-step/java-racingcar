package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class RacingCar {
    private static final int FORWARD_CONDITION = 4;

    private final int carNums;
    private final int tryNums;

    public RacingCar(int carNums, int tryNums) {
        this.carNums = carNums;
        this.tryNums = tryNums;
    }

    public void racingStart() {
        ResultView.printStartMessage();
        List<Car> carList = createCarList();
        for (int i = 0; i < tryNums; i++) {
            moveFowardCarList(carList);
            ResultView.printResult(carList);
        }
    }

    private List<Car> createCarList() {
        List<Car> carList = new ArrayList<>();
        for (int i = 0; i < carNums; i++) {
            carList.add(new Car());
        }
        return carList;
    }

    private void moveFowardCarList(List<Car> carList) {
        for (Car car : carList) {
            moveFowardCar(car);
        }
    }

    private void moveFowardCar(Car car) {
        if (forwardCondition()) {
            car.moveForward();
        }
    }

    private boolean forwardCondition() {
        int randomValue = generateRandomValue();
        return isForwardCondition(randomValue);
    }

    private static int generateRandomValue() {
        return new Random().nextInt(10);
    }

    private static boolean isForwardCondition(int value) {
        return value >= FORWARD_CONDITION;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RacingCar racingCar = (RacingCar) o;
        return carNums == racingCar.carNums && tryNums == racingCar.tryNums;
    }

    @Override
    public int hashCode() {
        return Objects.hash(carNums, tryNums);
    }
}
