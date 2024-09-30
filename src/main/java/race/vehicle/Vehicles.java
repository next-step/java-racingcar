package race.vehicle;

import race.Utils.ResultUtils;

import java.util.ArrayList;
import java.util.List;

public class Vehicles {
    public static final String INITIAL_LOCATION = "-";
    List<Car> list = new ArrayList<>();

    public Vehicles(int num) {
        initList(num);
    }

    Vehicles initList(int num) {
        for (int i = 0; i < num; i++) {
            list.add(new Car.Builder().initlocation(INITIAL_LOCATION).build());
        }
        return this;
    }

    public void gameStart(int num) {
        ResultUtils.printResultView();
        for (int i = 0; i < num; i++) {
            for (Car car : list) {
                car.move();
            }
            System.out.println();
        }
    }

}
