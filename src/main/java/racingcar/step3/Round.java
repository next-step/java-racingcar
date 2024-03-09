package racingcar.step3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Round {

    private final List<Car> cars;

    public Round(int carsNumber) {
        cars = createCarsList(carsNumber);
    }

    public void startRound(Random random) {
        cars.forEach(car -> car.decideAction(random.nextInt(10)));
    }

    public void printRoundResult() {
        cars.stream().map(Car::getCurrentLocation).forEach(System.out::println);
    }

    private List<Car> createCarsList(int carNumbers) {
        List<Car> cars = new ArrayList<Car>();

        for (int i = 0; i < carNumbers; i++) {
            cars.add(new Car());
        }

        return cars;
    }
}
