package step2.racing;

import java.util.List;

public class Winners {
    private static final String DELIMITER = ", ";
    private List<Model> winners;

    public Winners(List<Model> winners) {
        this.winners = winners;
    }

    @Override
    public String toString() {
        return winners.stream()
                .map(model -> model.toString())
                .reduce((o1, o2) -> o1 + DELIMITER + o2)
                .orElseThrow(() -> new IllegalArgumentException());
    }
}
