package step4.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Winners {

    private List<Car> winners;

    public Winners(List<Car> winners) {
        this.winners = winners;
    }

    public static Winners from(Cars cars) {
        int winnerPosition = cars.findWinnerPosition();
        List<Car> winners = cars.getCars().stream()
                .filter(car -> car.isSamePosition(winnerPosition))
                .collect(Collectors.toList());

        return new Winners(winners);
    }

    public List<Car> getWinners() {
        return Collections.unmodifiableList(winners);
    }
}
