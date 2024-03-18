package carRacing;

import java.util.List;
import java.util.stream.Collectors;

public class Winner {

    private List<Car> cars;

    public Winner(List<Car> cars) {
        this.cars = cars;
    }

    private  int maxPosition() {
        return cars.stream().map(car ->
                car.getPosition()
        ).max(Integer::compareTo).orElseThrow(() -> new IllegalArgumentException("position값이 올바르지않습니다."));
    }

    public  List<Car> findWinner() {
        int maxPosition = maxPosition();
        return cars.stream().filter(car -> car.getPosition() == maxPosition
        ).collect(Collectors.toList());
    }
}
