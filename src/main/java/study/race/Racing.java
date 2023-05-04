package study.race;

import study.race.view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class Racing {

    public static List<Car> carArray(String[] names) {
        List<Car> cars = new ArrayList<>(names.length);
        for (int i = 0; i < names.length; i++) {
            cars.add(new Car(names[i]));
        }
        return cars;
    }

    public static List<Car> racing(int racingCount, List<Car> cars) {
        for (int i = 0; i < racingCount; i++) {
            move(cars);
            ResultView.resultViewRace(cars);
        }
        return cars;
    }

    private static void move(List<Car> cars) {
        for (Car car : cars) {
            car.move();
        }
    }

}
