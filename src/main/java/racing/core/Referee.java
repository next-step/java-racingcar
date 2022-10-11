package racing.core;

import java.util.List;
import java.util.stream.Collectors;

public class Referee {

    public List<Car> getWinners(List<Car> cars) {
        cars.sort((o1, o2) -> o2.getDistance() - o1.getDistance());
        Car firstWinner = cars.get(0);
        int winnerScore = firstWinner.getDistance();
        return cars.stream()
                .filter(car -> car.getDistance() == winnerScore)
                .collect(Collectors.toList());
    }

}
