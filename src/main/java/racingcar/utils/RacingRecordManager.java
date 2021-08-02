package racingcar.utils;

import racingcar.domain.RacingRecords;

import java.util.List;

public class RacingRecordManager {

    public static List<String> getRacingWinner(List<RacingRecords> racingRecords) {
        return getFinalRacingRecord(racingRecords).getRacingWinner();
    }

    private static RacingRecords getFinalRacingRecord(List<RacingRecords> racingRecords) {
        return racingRecords.get(racingRecords.size() - 1);
    }
}
