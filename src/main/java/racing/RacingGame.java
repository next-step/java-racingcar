package racing;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private final RacingGameSpec racingGameSpec;
    private final RacingCars racingCars;
    private final RacingLap racingLap;

    private RacingGame(final RacingGameSpec racingGameSpec, final RacingCars racingCars, final RacingLap racingLap) {
        this.racingGameSpec = racingGameSpec;
        this.racingCars = racingCars;
        this.racingLap = racingLap;
    }

    public static RacingGame init(final String carNames, final int trialCount) {
        return new RacingGame(
                RacingGameSpec.init(),
                RacingCars.init(carNames),
                RacingLap.init(trialCount)
        );
    }

    public RacingGamePrize start() {
        List<RacingCars> result = new ArrayList<>();
        result.add(racingCars);

        for (int idx=0; idx < racingLap.getLap(); idx++) {
            result.add(
                    result.get(idx).race(racingGameSpec)
            );
        }
        return RacingGamePrize.init(result);
    }
}
