package racing_car.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class RacingGame {

    private final RacingCarList racingCarList;
    private final RacingSpec racingSpec;

    public RacingGame(RacingSpec racingSpec) {
        this.racingCarList = new RacingCarList(racingSpec.getUsers());
        this.racingSpec = racingSpec;
    }

    public RacingRecord play() {
        List<LabRecord> labRecords = new ArrayList<>();
        IntStream
                .range(0, racingSpec.getLab())
                .forEach(i -> {
                    labRecords.add(racingCarList.moveCars());
                });
        return new RacingRecord(labRecords);
    }

}
