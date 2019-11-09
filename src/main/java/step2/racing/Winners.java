package step2.racing;

import java.util.List;

public class Winners {
    private static final String DELIMITER = ", ";
    private List<String> winners;

    public Winners(List<String> winners) {
        this.winners = winners;
    }

    @Override
    public String toString() {
        return winners.stream()
                .reduce((o1, o2) -> o1 + ", " + o2)
                .orElseThrow(() -> new IllegalArgumentException());
    }
}
