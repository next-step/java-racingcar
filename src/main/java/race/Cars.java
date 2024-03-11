package race;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private List<Car> carList = new ArrayList<>();

    public Cars(int numberOfCar) {
        for (int i = 0; i < numberOfCar; i++) {
            this.carList.add(i, new Car());
        }
    }

    public String forward(int numberOfCar, int count) {
        return this.carList.get(numberOfCar - 1).goForward(count);
    }

}
