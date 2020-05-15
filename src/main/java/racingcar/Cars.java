package racingcar;

import java.util.List;
import java.util.Objects;
import static java.util.stream.Collectors.toList;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars){
        if(Objects.isNull(cars)) {
            throw new NullPointerException();
        }
        this.cars = cars;
    }

    public List<Integer> moveAll(){
        return cars.stream()
                .map(Car::move)
                .collect(toList());
    }

}
