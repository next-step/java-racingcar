package step3_racingCar;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Cars {
    private List<Car> cars;
    private int tryNum;

    public Cars(int tryNum) {
        this.cars = new LinkedList<Car>();
        this.tryNum = tryNum;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public int getTryNum() {
        return tryNum;
    }

    public LinkedList<Integer> checkForward(){
        LinkedList<Integer> forwardNums = new LinkedList<>();
        cars.stream().forEach(car -> {
            forwardNums.add(car.getForwardNum());
        });
        return forwardNums;
    }
}
