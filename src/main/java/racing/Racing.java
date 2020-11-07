package racing;

import racing.ui.ResultView;

import java.util.ArrayList;
import java.util.List;

public class Racing {

    public static void race(int numberOfParticipationCars, int numberOfParticipationTry) {
        List<Car> cars = createParticipationCars(numberOfParticipationCars);
        start(numberOfParticipationTry, cars);
    }


    static List<Car> createParticipationCars(int numberOfParticipationCars) {
        List<Car> cars = new ArrayList<>();
        for (int j = 0; j < numberOfParticipationCars; j++) {
            cars.add(new Car());
        }

        return cars;
    }

    private static void start(int numberOfParticipationTry, List<Car> cars) {
        for (int i = 0; i < numberOfParticipationTry; i++) {
            Car.forward(cars);
            ResultView.output(cars);
        }
    }
}
