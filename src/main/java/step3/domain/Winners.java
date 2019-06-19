package step3.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Winners {

    private List<Car> winners;

    private Winners(List<Car> winners) {
        this.winners = winners;
    }

    public static Winners pickWinners(Cars cars) {
        int winnerPosition = cars.findWinnerPosition();
        List<Car> winners = cars.getCars().stream()
                .filter(car -> cars.isWinnerPosition(winnerPosition, car))
                .collect(Collectors.toList());

        return new Winners(winners);
    }

    public List<Car> getWinners() {
        return Collections.unmodifiableList(winners);
    }
}
