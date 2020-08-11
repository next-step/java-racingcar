package racingcar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Cars {
    private List<Car> cars = new ArrayList<>();

    public Cars(List<String> carName) {
        makeCars(carName);
    }

    public List<Car> carList() {
//        return Collections.unmodifiableList(cars);
        return cars;
    }

    public void makeCars(List<String> carName) {
        /*cars = Stream.generate(() -> new Car(carName.get()))
                .limit(carName.size())
                .collect(Collectors.toList());*/
        for (int i = 0; i < carName.size(); i++) {
            cars.add(new Car(carName.get(i)));
        }
    }

    public void moveCars() {
        cars.forEach(car -> {
            int random = RacingGame.randomNumber();
            car.move(random);
        });
    }
}
