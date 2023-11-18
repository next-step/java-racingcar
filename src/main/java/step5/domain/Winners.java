package step5.domain;

import step5.controller.OutPutView;
import step5.domain.car.Car;

import java.util.List;

public class Winners {
    private final List<Car> winners;

    private Winners(List<Car> winners) {
        this.winners = winners;
    }


    public static Winners of(List<Car> winners) {
        return new Winners(winners);
    }

    public int count() {
        if (winners == null) {
            return 0;
        }

        return winners.size();
    }

    public String toStringWinner() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Car car : this.winners) {
            stringBuilder.append(car.nameToString());
            stringBuilder.append(", ");
        }
        String winners = stringBuilder.toString().trim();
        return winners.substring(0, winners.length() - 1);
    }
}
