package carRacing.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Game {

    public List<Car> race(List<Car> cars){
        return cars.stream()
                .map((car) -> car.raceOrStay(car))
                .collect(Collectors.toList());
    }

}
