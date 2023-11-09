package step3;

import java.util.ArrayList;
import java.util.List;

public class MoveCarStatus {
    private List<Car> cars = new ArrayList<>();

    public MoveCarStatus(String[] carNames, int position, int decisionValue) {
        for(String carName : carNames) {
            cars.add(new Car(carName, position, decisionValue));
        }
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }
}
