package racing.domain;

import racing.msg.SystemMention;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private final int cntOfCar;
    private final int cntOfTry;
    private List<Car> carList;

    public Cars(int cntOfCar, int cntOfTry) {
        this.cntOfCar = cntOfCar;
        this.cntOfTry = cntOfTry;
        setCarList();
    }

    private void setCarList() {
        carList = new ArrayList<>();
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
            car.move(Moving.moveNumber());
            System.out.println(car.positionStatus());
        }
        System.out.println();
    }

    public int getCarListSize() {
        return carList.size();
    }
}
