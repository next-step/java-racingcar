package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingCar {
    private static final int FORWARD_CONDITION = 4;

    private final int carNums;
    private final int tryNums;

    public RacingCar(int carNums, int tryNums) {
        this.carNums = carNums;
        this.tryNums = tryNums;
    }

    public void racingStart() {
        System.out.println("실행 결과");
        List<Car> carList = createCarList();
        for (int i = 0; i < tryNums; i++) {
            //System.out.println("===START RACING " + (i + 1) + "===");
            moveFowardCarList(carList);
            ResultView.printResult(carList);
            //System.out.println("===END RACING " + (i + 1) + "===");
        }
    }

    private List<Car> createCarList() {
        List<Car> carList = new ArrayList<>();
        for (int i = 0; i < carNums; i++) {
            carList.add(new Car(i));
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
        double random = Math.random();
        int value = (int) (random * 10);
        return isForward(value);
    }

    private static boolean isForward(int value) {
        return value >= FORWARD_CONDITION;
    }
}
