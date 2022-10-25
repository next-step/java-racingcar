package step3;

import java.util.ArrayList;
import java.util.List;

public class CarStorage {

    public static List<Car> exit(String[] carNames) {
        List<Car> cars = new ArrayList<Car>();

        for(int count = 0; count < carNames.length; count++){
            String name = carNames[count];
            cars.add(new Car(name));
        }

        return cars;
    }


}
