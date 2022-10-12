package racing.core;

import java.util.List;
import java.util.stream.Collectors;

public class Referee {

    public CarList getWinners(CarList cars) {
        cars.sortDesc();
        Car firstWinner = cars.getFirstCar();
        int winnerScore = firstWinner.getDistance();
        List<Car> result = cars.getCarStream()
                .filter(car -> car.getDistance() == winnerScore)
                .collect(Collectors.toList());
        return new CarList(result);
    }

}
