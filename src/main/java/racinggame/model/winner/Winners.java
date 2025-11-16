package racinggame.model.winner;

import java.util.ArrayList;
import java.util.List;
import racinggame.model.car.CarName;

public class Winners {
    private final List<CarName> winners;

    public Winners(List<CarName> winners) {
        this.winners = winners;
    }

    public String getResultMessage() {
        List<String> rawWinners = new ArrayList<>();
        for (CarName winner : winners) {
            rawWinners.add(winner.toString());
        }

        return String.join(", ", rawWinners);
    }
}
