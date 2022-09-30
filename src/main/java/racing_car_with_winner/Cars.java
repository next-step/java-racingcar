package racing_car_with_winner;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private List<Car> cars;

    public Cars(String[] carNames) {
        this.cars = new ArrayList<>();

        for (String carName : carNames) {
            this.cars.add(new Car(new CarName(carName)));
        }
    }

    public List<Car> getCars() {
        return cars;
    }
}
