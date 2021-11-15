package step3.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.function.IntSupplier;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> carList;

    Cars(int numberOfCars) {
        carList = new ArrayList<>();
        for (int i = 0; i < numberOfCars; i++) {
            carList.add(new Car());
        }
    }

    public void playOneRound(IntSupplier rule) {
        for (Car car : carList) {
            int distance = rule.getAsInt();
            car.move(distance);
        }
    }

    public List<Integer> getPosition(int round) {
        return carList.stream()
                .map(car -> car.getPosition(round))
                .collect(Collectors.toList());

    }
}
