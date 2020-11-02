package step3;

import java.util.List;
import java.util.stream.IntStream;

public class RacingGame {

    private final RacingSpec racingSpec;
    private final RacingRecord racingRecord = new RacingRecord();
    private final RacingCarManager racingCarManager = new RacingCarManager();

    public RacingGame(RacingSpec racingSpec) {
        if (racingSpec == null) {
            throw new NullPointerException(ErrorMessage.RACING_SPEC_IS_NULL);
        }
        this.racingSpec = racingSpec;
        initRacingGame();
    }

    private void initRacingGame() {
        IntStream.range(0, racingSpec.getCarCount()).forEach(i -> racingCarManager.joinCar());
    }

    public void start() {
        IntStream.range(0, racingSpec.getMoveCount()).forEach(i -> {
            racingCarManager.moveCars();
            List<Integer> racingStatus = racingCarManager.getRacingStatus();
            racingRecord.saveOneStepRecord(racingStatus);
        });
    }

    public List<List<Integer>> getRacingLog() {
        return racingRecord.getRacingRecord();
    }

}
