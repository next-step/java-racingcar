package step3.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Winners {

    private List<Car> winners;

    private Winners(List<Car> winners) {
        this.winners = winners;
    }

    public static Winners pickWinners(Cars cars) {

        List<Car> winners = new ArrayList<>();
        int winnerPosition = 0;

        for (Car car : cars.getCars()) {
            if (car.getPosition() > winnerPosition) {
                winnerPosition = car.getPosition();
            }
        }
        for (Car car : cars.getCars()) {
            if (car.getPosition() == winnerPosition) {
                winners.add(car);
            }
        }
        return new Winners(winners);
    }

    public List<Car> getWinners() {
        return Collections.unmodifiableList(winners);
    }
}
