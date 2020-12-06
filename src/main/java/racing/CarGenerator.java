package racing;

import java.util.ArrayList;
import java.util.List;

public class CarGenerator {
    private List<Car> cars = new ArrayList<>();

    public List<Car> generateCar(int number) {
        for(int i = 0; i < number; i ++){
            cars.add(new Car());
        }
        return cars;
    }
}
