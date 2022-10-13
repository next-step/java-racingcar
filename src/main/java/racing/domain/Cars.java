package racing.domain;

import racing.msg.SystemMention;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private final int cntOfCar;
    private final int cntOfTry;
    private final List<Car> carList = new ArrayList<>();

    public Cars(int cntOfCar, int cntOfTry) {
        this.cntOfCar = cntOfCar;
        this.cntOfTry = cntOfTry;
        for (int i = 0; i < this.cntOfCar; i++) {
            carList.add(new Car());
        }
    }

    public void tryMove() {
        SystemMention.RESULT.printMention();
        for (int i = 0; i < cntOfTry; i++) {
            moveCars();
        }
    }

    private void moveCars() {
        for (Car car : carList) {
            car.move();
            car.printPosition();
        }
        System.out.println();
    }
}
