package step3;

import java.util.ArrayList;
import java.util.List;

public class MoveCarStatus {
    private List<Car> cars = new ArrayList<>();

    public MoveCarStatus(String[] carNames, int position) {
        for(String carName : carNames) {
            cars.add(new Car(carName, position));
        }
    }

    public List<Car> getCars() {
        return cars;
    }
}
