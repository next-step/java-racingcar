package race;

import java.util.List;

public class Cars {

    private final List<Car> carList;

    public Cars(List<Car> carList) {
        this.carList = carList;
    }

    public List<Car> getCarList() {
        return carList;
    }

    protected Cars moveCars(Cars carList) {
        for (Car car: carList.getCarList()) {
            car.setDistance(RandomNumCondition.move(new RandomNumCondition()));
        }
        return carList;
    }

}
