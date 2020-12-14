package step3;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CarWinnerDiscriminator {

    public static List<Car> discriminate(List<Car> cars) {
        int winnerMoveCount = cars.stream()
                .max(Comparator.comparing(Car::getMoveCount))
                .get()
                .getMoveCount();
        return cars.stream()
                .filter(car -> car.isWinner(winnerMoveCount))
                .collect(Collectors.toList());
    }


}
