package step5.model;

import java.util.ArrayList;
import java.util.List;

public class Winners {
    private final List<Car> winner;
    
    public Winners(List<Car> winners) {
        this.winner = winners;
    }

    public List<Car> getWinner() {
        return winner;
    }
}
