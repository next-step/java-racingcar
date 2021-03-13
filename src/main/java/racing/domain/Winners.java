package racing.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Winners {

    public static final int EMPTY_VALUE = 0;

    public Winners(){
    }

    public List<Winner> winners(List<Car> cars){
        int max = maxMoveCount(cars);
        return cars.stream().
            filter(car -> car.isWinner(max))
            .map(car -> new Winner(car.getName()))
            .collect(Collectors.toList());
    }

    public int maxMoveCount(List<Car> cars){
        return cars
            .stream()
            .mapToInt(Car::getMoveCount)
            .max()
            .orElse(EMPTY_VALUE);
    }

}
