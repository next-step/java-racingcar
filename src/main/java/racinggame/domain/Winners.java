package racinggame.domain;

import java.util.ArrayList;
import java.util.List;

public class Winners {

    private final List<String> winnerNames;

    public Winners(List<String> winnerNames) {
        this.winnerNames = new ArrayList<>(winnerNames);
    }

    public String formatWinners() {
        return String.join(", ", winnerNames);
    }

    @Override
    public String toString() {
        return formatWinners();
    }

    public List<String> getNames() {
        return new ArrayList<>(winnerNames);
    }
}
