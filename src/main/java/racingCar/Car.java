package racingCar;

import java.util.ArrayList;
import java.util.List;

public class Car {

    List<String> cars = new ArrayList<>();

    public Car(int N) {
        for (int i =0; i < N; i++) {
            this.cars.add("-");
        }
    }

}
