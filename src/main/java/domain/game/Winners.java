package domain.game;

import java.util.ArrayList;
import java.util.List;


public class Winners {
    private List<String> winners;

    public Winners() {
        this.winners = new ArrayList<>();
    }

    public void add(String name) {
        winners.add(name);
    }

    public List<String> getWinners() {
        return winners;
    }
}
