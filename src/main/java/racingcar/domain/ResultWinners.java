package racingcar.domain;

import java.util.List;

public class ResultWinners {
    private List<String> winners;

    public ResultWinners(List<String> winners) {
        this.winners = winners;
    }

    public List<String> getWinners() {
        return winners;
    }
}
