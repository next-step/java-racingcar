package racing;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars = new ArrayList<>();

    public void addCar(Car... car) {
        cars.addAll(List.of(car));
    }

    public int size() {
        return cars.size();
    }

    public List<String> dashOfCarPositions() {
        return cars.stream()
                .map(Car::carPosition)
                .collect(Collectors.toList());
    }

    public void playRound() {
        for (Car car : cars) {
            car.play();
        }
    }

}
