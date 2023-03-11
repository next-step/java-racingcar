package racing;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private List<Car> cars = new ArrayList<>();

    public Cars(List<String> carEntry) {
        for (int i = 0; i < carEntry.size(); i++) {
            cars.add(new Car(carEntry.get(i)));
        }
    }

    public List<Car> getCars() {
        return this.cars;
    }
}
