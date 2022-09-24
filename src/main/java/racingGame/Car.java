package racingGame;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Car {
    private static final String CAR_TRACE = "-";
    private List<String> carTraces = new ArrayList<>();
    public void move() {
        carTraces.add(CAR_TRACE);
    }

    public void size(){
        System.out.println(carTraces.size());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(carTraces, car.carTraces);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carTraces);
    }

}
