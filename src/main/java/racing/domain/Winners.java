package racing.domain;

import java.util.List;

public class Winners {

    List<String> winners;

    public Winners(List<String> winners) {
        this.winners = checkWinners(winners);
    }

    private List<String> checkWinners(List<String> winners) {
        if (winners.isEmpty()) {
            throw new IllegalArgumentException("우승자는 최소 1명 이상이여야합니다.");
        }
        return winners;
    }

    public List<String> getWinners() {
        return winners;
    }
}
