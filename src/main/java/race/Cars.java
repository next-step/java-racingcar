package race;

import java.util.List;

public class Cars {

    private List<Car> carList;

    public Cars(List<Car> carList, int numberOfCars) {
        this.carList = carList;
        for (int i = 0; i < numberOfCars; i++) {
            this.carList.add(new Car());
        }
    }

    public List<Car> getCarList() {
        return carList;
    }
}
