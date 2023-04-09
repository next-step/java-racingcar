package racing;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> carList;

    public Cars(int number) {
        List<Car> carList = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            carList.add(new Car());
        }
        this.carList = carList;
    }

    public static Cars createCars(int input) {
        return new Cars(input);
    }

    public List<Car> valueOf() {
        return carList;
    }
}
