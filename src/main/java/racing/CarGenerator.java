package racing;

import java.util.ArrayList;
import java.util.List;

public class CarGenerator {
    public Cars generateCar(int number) {
        List<Car> cars = new ArrayList<>();
        for(int i = 0; i < number; i ++){
            cars.add(new Car());
        }
        return new Cars(cars);
    }
}
