package racing;

import java.util.ArrayList;
import java.util.List;

public class RacingGamePrize {

    private final List<RacingRecordCars> racingRecords;

    private RacingGamePrize(final List<RacingRecordCars> racingRecords) {
        this.racingRecords = racingRecords;
    }

    public static RacingGamePrize init(final List<RacingCars> racingResult) {
        List<RacingRecordCars> racingRecords = new ArrayList<>();
        for (RacingCars racingCars: racingResult) {
            racingRecords.add(RacingRecordCars.init(racingCars));
        }
        return new RacingGamePrize(racingRecords);
    }

    public List<RacingRecordCars> getRacingRecords() {
        return racingRecords;
    }

    public RacingRecordCars getWinners() {
        RacingRecordCars lastResult = racingRecords.get(racingRecords.size() - 1);
        return lastResult.getLeads();
    }
}
