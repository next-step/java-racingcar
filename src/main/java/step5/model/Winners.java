package step5.model;

import java.util.ArrayList;
import java.util.List;

public class Winners {
    private final List<String> winnerNames = new ArrayList<>();

    public void addWinner(String name) {
        this.winnerNames.add(name);
    }

    public List<String> getWinnerNames() {
        return winnerNames;
    }

    public int size() {
        return winnerNames.size();
    }
}
