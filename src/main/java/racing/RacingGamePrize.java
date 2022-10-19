package racing;

import java.util.List;

public class RacingGamePrize {

    private final List<RacingCars> racingResult;

    private RacingGamePrize(List<RacingCars> racingResult) {
        this.racingResult = racingResult;
    }

    public static RacingGamePrize init(List<RacingCars> racingResult) {
        return new RacingGamePrize(racingResult);
    }

    public RacingCars getWinners() {
        RacingCars lastResult = racingResult.get(racingResult.size() - 1);
        return lastResult.getLeads();
    }
}
