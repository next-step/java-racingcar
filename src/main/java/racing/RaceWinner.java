package racing;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RaceWinner {
    private final List<Car> winners = new ArrayList<>();

    public RaceWinner(Cars cars) {
        List<Car> carList = cars.getCars();
        carList.sort((car1, car2) -> car2.getPosition() - car1.getPosition());
        int winner_distance = carList.get(0).getPosition();
        winners.addAll(carList.stream()
                .filter(car -> car.getPosition() == winner_distance)
                .collect(Collectors.toList()));
    }

    public List<Car> getWinners() {
        return winners;
    }
}
