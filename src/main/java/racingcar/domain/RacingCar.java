package racingcar.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class RacingCar {
    private final List<Car> cars;

    public RacingCar(List<Car> cars){
        this.cars = cars;
    }

    public List<Car> getCars(){
        return cars;
    }

    public List<String> getWinnerList(int location) {
        return cars.stream()
                .filter(car -> car.getLocation() == location)
                .map(Car::getCar)
                .collect(Collectors.toList());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Scoreboard scoreboard = (Scoreboard) obj;
        return Objects.equals(cars, scoreboard.getRacingCar().getCars());
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars);
    }
}