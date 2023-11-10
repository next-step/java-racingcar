package racingcar;

import java.util.List;

public class Cars {

    private List<Car> carList;

    public Cars(List<Car> carList) {
        this.carList = carList;
    }

    protected void move() {
        for (Car car : carList) {
            car.move(RacingCar.getRandom());
        }
    }

    List<Car> getCars() {
        return this.carList;
    }

}
