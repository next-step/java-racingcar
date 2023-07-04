package racingcar;

import java.util.ArrayList;
import java.util.List;

public class CarDto {
    private final String name;
    private final int distance;

    public CarDto(String name, int distance) {
        this.name = name;
        this.distance = distance;
    }

    public static CarDto from(Car car) {
        return new CarDto(car.getName(), car.getDistance());
    }

    public static List<CarDto> getListOf(List<Car> cars) {
        List<CarDto> result = new ArrayList<>();
        for (Car car : cars) {
            result.add(from(car));
        }

        return result;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }
}
