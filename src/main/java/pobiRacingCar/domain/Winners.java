package pobiRacingCar.domain;

import java.util.ArrayList;
import java.util.List;

public class Winners {

    private final List<Car> winners;

    public Winners(List<Car> winners) {
        this.winners = winners;
    }

    public String createWinnerNames() {
        List<String> winnerNames = new ArrayList<>();
        for (Car winner : winners) {
            winnerNames.add(winner.getName().getName()); //ui getter ok, carName.getName
        }
        return String.join(",", winnerNames);
    }

    public List<Car> getWinners() {
        return winners;
    }
}
