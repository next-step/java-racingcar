package racing;

import java.util.ArrayList;
import java.util.List;

public class CarGenerator {
    public List<Car> createCars(String carNames, int nameLengthCondition, int moveCondition){
        final String[] names = carNames.split(",");
        final List<Car> cars = new ArrayList<>();

        for (String name : names) {
            cars.add(new Car(name, nameLengthCondition, moveCondition));
        }

        return cars;
    }
}
