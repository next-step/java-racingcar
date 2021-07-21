package step3.race;

import step3.model.Car;

import java.util.ArrayList;
import java.util.List;

public class Race {

    private List<Car> cars;

    public Race(int counts) {
        cars = new ArrayList<>();
        makeCars(counts);
    }

    private void makeCars(int counts) {
        for (int idx = 0; idx < counts; idx++) {
            cars.add(new Car(idx));
        }
    }

    public void racing(){

    }

}
