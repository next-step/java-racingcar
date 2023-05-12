package step3.domain;

import java.util.ArrayList;
import java.util.List;

public class Car {
    private final List<Integer> movingList;
    private static final int NOT_MOVED = 0;
    private static final int MOVED = 1;

    public Car() {
        this.movingList = new ArrayList<>();
    }

    public static List<Car> factory(int numOfCars) {
        List<Car> carList = new ArrayList<>();
        for(int i = 0; i < numOfCars; i++) {
            carList.add(new Car());
        }
        return carList;
    }

    public void drive(int randomNumber) {
        addMoving(willMoving(randomNumber) ? MOVED : NOT_MOVED);
    }

    public void addMoving(int movement) {
        movingList.add(movement);
    }

    public List<Integer> getMovingList() {
        return movingList;
    }

    public static boolean willMoving(int number) {
        return number >= 4;
    }

}
