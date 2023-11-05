package step3;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private List<Car> cars = new ArrayList<>();

    public Cars() {

    }

    public Cars(int numOfCars) {
        for (int i=0; i<numOfCars; i++) {
            cars.add(new Car());
        }
    }

    public int getNumOfCars() {
        return cars.size();
    }
}
