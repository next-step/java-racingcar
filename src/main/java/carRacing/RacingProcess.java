package carRacing;

import java.util.ArrayList;
import java.util.List;

public class RacingProcess {
    private final int carCount;
    private final List<Car> carList = new ArrayList<>();

    public RacingProcess(int carCount) {
        this.carCount = carCount;

    }

    public void ready() {
        for (int i = 0; i < carCount; i++) {
            carList.add(new Car());
        }
    }

    public void round() {
        for (Car car : carList) {
            race(car);
        }
    }


    public void race(Car car) {
        if (isRide(RandomNumber.generate())) {
            car.move();
        }
    }


    public List<Car> showCarList() {
        return carList;
    }


    public boolean isRide(int number) {
        return number >= 4;
    }


}
