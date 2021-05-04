package racing.domain;

import java.util.List;
import java.util.Objects;

public class Winners {
    private List<String> winners;

    private Winners(List<String> winners) {
        this.winners = winners;
    }

    public static Winners of(List<String> winners) {
        validate(winners);
        return new Winners(winners);
    }

    private static void validate(List<String> winners) {
        if (Objects.isNull(winners) || winners.size() < 1) {
            throw new IllegalArgumentException("우승자는 1명 이상이어야합니다.");
        }
    }

    public int size() {
        return winners.size();
    }

    @Override
    public String toString() {
        return String.join(Cars.DELIMITER, winners);
    }
}
