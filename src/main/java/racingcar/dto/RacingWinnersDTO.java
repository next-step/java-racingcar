package racingcar.dto;

import java.util.List;

public final class RacingWinnersDTO {
    private final List<String> winners;

    private RacingWinnersDTO(List<String> winners) {
        this.winners = winners;
    }

    public static RacingWinnersDTO valueOf(List<String> winners) {
        return new RacingWinnersDTO(winners);
    }

    public List<String> getWinners() {
        return this.winners;
    }
}
