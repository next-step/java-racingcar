package CarRacing;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class Winner {

    public static List<String> printWinner(List<Car> cars) {

        List<String> winner =
                cars.stream()
                        .filter(car -> car.isSamePostion(getMaxPositionCar(cars)))
                        .map(Car::getCarName).collect(Collectors.toList());
        return winner;
    }

    private static Car getMaxPositionCar(List<Car> cars) {

        Comparator<Car> comparatoryByPosition = Comparator.comparingInt(Car::getPosition);

        Car winnerCar = cars.stream()
                .max(comparatoryByPosition)
                .orElseThrow(NoSuchElementException::new);
        return winnerCar;
    }

}
