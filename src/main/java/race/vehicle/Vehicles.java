package race.vehicle;

import java.util.ArrayList;
import java.util.List;

public class Vehicles {
    public static final int INITIAL_LOCATION = 1;
    List<Car> list = new ArrayList<>();

    public Vehicles(int num){
        initList(num);
    }

    Vehicles initList(int num) {
        for (int i = 0; i < num; i++) {
            list.add(new Car(INITIAL_LOCATION));
        }
        return this;
    }
}
