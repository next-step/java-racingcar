package step5.domain;

import java.util.List;

public class WinnersResponse {
    private final List<Car> winners;

    public WinnersResponse(List<Car> winners) {
        this.winners = winners;
    }

    public List<Car> getWinners() {
        return winners;
    }
}
