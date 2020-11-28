package racingcar.domain;

import java.util.List;
import java.util.Objects;

public class RacingCar {
    private List<Car> cars;

    public List<Car> getCars(){
        return cars;
    }

    public RacingCar(List<Car> cars){
        this.cars = cars;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Scoreboard scoreboard = (Scoreboard) obj;
        return Objects.equals(cars, scoreboard.getCars());
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars);
    }
}