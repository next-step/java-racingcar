package racing.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RaceWinner {
    private final List<Car> winners = new ArrayList<>();

    public RaceWinner(Cars cars) {
        List<Car> carList = cars.getCars();
        carList.sort((car1, car2) -> car2.position() - car1.position());
        int winner_distance = carList.get(0).position();
        winners.addAll(carList.stream()
                .filter(car -> car.position() == winner_distance)
                .collect(Collectors.toList()));
    }

    public List<Car> getWinners() {
        return winners;
    }
}
