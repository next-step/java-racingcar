package step4.model;

import java.util.ArrayList;
import java.util.List;

public class Winners {
    private final List<String> winnerNames = new ArrayList<>();

    public void addWinner(String name) {
        this.winnerNames.add(name);
    }

    public String getWinnerNames() {
        return String.join(", ", winnerNames);
    }

    public int size() {
        return winnerNames.size();
    }
}
