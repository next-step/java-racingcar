package step5.model;

import java.util.ArrayList;
import java.util.List;

public class Winners {
    private final List<Car> winner;
    
    public Winners(List<Car> winners) {
        this.winner = winners;
    }

    public String createWinnerNames() {
        List<String> winnerNames = new ArrayList<>();

        for (Car winner : winner) {
            winnerNames.add(winner.getName());
        }
        return String.join(",",winnerNames);
    }

    public List<Car> getWinner() {
        return winner;
    }
}
