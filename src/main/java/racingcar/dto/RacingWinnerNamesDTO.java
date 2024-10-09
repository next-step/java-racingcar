package racingcar.dto;

import racingcar.domain.RacingCar;

import java.util.ArrayList;
import java.util.List;

public final class RacingWinnerNamesDTO {
    private final List<String> winnerNames;

    private RacingWinnerNamesDTO(List<String> winners) {
        this.winnerNames = winners;
    }

    public static RacingWinnerNamesDTO valueOf(List<RacingCar> winners) {
        List<String> winnerNames = new ArrayList<>();
        for(RacingCar winner: winners) {
            winnerNames.add(winner.getName());
        }
        return new RacingWinnerNamesDTO(winnerNames);
    }

    public List<String> getWinnerNames() {
        return this.winnerNames;
    }
}
