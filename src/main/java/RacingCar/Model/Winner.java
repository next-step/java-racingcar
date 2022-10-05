package RacingCar.Model;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Winner {
    public List<Car> winner(List<Car> carList) {
        var optional = carList.stream().max(Comparator.comparing(Car::getPosition));

        int max = optional.get().getPosition();

        return carList.stream().filter(x -> x.getPosition() == max).collect(Collectors.toList());
    }
}
