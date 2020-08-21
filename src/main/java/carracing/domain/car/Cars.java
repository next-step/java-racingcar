package carracing.domain.car;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Cars {
    private List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = new ArrayList<>(cars); //defensive copy : 생성자의 인자로 받은 객체를 새로운 객체에 복사.
    }

    public List<Car> getCars() {
        return new ArrayList<>(cars);
    }

    public String getWinner() {
        int maxPosition = getMaxPosition();
        return cars.stream()
                .filter(car -> car.isMaxPosition(maxPosition))
                .flatMap(car -> Stream.of(car.getCarName()))
                .collect(Collectors.joining(","));
    }
    private int getMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .getAsInt();
    }

}
