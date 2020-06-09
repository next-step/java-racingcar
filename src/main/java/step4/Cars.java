package step4;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Cars {

    private static final String SPLIT_REGEX = ",";
    private static final String EMPTY = "";

    private final List<Car> cars = new ArrayList<>();

    public Cars(String names) {
        invalid(names);
        split(names);
    }

    public void split(String names) {
        String[] list = names.split(SPLIT_REGEX);
        for(String name: list) {
            this.cars.add(Car.of(name));
        }
    }

    public Result move() {
        List<Car> list = moveCars();
        return new Result(list);
    }

    private List<Car> moveCars() {
        return cars.stream().map(car -> {
                car.move(new Fuel());
                return car;
            }).collect(Collectors.toList());
    }

    private void invalid(String names) {
        if(names == EMPTY) {
            throw new IllegalArgumentException();
        }
        if(names == null) {
            throw new IllegalArgumentException();
        }
    }

    public List<Car> getCars() {
        return cars;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cars cars1 = (Cars) o;
        return Objects.equals(cars, cars1.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars);
    }


}