package racing.domain;

import java.util.ArrayList;
import java.util.List;

public class RoundCars {
    private List<List<Car>> roundCars = new ArrayList<>();

    public List<List<Car>> getRoundCars() {
        return roundCars;
    }

    public void addRound(List<Car> car){
        this.roundCars.add(car);
    }
}
