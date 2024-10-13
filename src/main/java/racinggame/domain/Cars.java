package racinggame.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import racinggame.dto.CarDto;
import racinggame.dto.History;
import racinggame.random.CapacityGenerator;

public class Cars {

    private final SnapShotStore snapShotStore = new SnapShotStore();
    private List<Car> cars;

    public Cars(List<Car> cars) {
        if (cars.isEmpty()) {
            throw new IllegalArgumentException("자동차가 비여 있을 수 없습니다.");
        }
        this.cars = cars;
    }

    public static Cars from(List<String> names) {
        return new Cars(carInitialization(names));
    }

    private static ArrayList<Car> carInitialization(List<String> names) {
        ArrayList<Car> cars = new ArrayList<>();
        for (String name : names) {
            cars.add(Car.defaultCar(name));
        }
        return cars;
    }

    public void move(CapacityGenerator capacityGenerator) {
        for (Car car : cars) {
            car.move(capacityGenerator.generate());
        }
        snapShotStore.save(nowState());
    }

    private List<CarDto> nowState() {
        List<CarDto> result = new ArrayList<>();
        for (Car car : cars) {
            result.add(new CarDto(car));
        }
        return result;
    }

    public History history() {
        return this.snapShotStore.snapShot();
    }

    public List<String> winners() {
        int max = cars.stream().mapToInt(Car::position).max().orElse(0);
        return cars.stream().filter(car -> car.isPositionEqual(max))
                .map(Car::name)
                .collect(Collectors.toList());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Cars cars1 = (Cars) o;
        return Objects.equals(cars, cars1.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars);
    }
}
