package racingcar.utils;

import racingcar.domain.RacingRecord;
import racingcar.domain.RacingRecords;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class RacingRecordManager {

    public static List<String> getRacingWinner(List<RacingRecords> racingRecords) {
        RacingRecords finalRacingHistory = getFinalRacingRecord(racingRecords);

        int maxPosition = getRacingMaxPosition(finalRacingHistory);

        return finalRacingHistory.getRacingRecords()
                .stream()
                .filter(u -> u.getPosition() == maxPosition)
                .map(u -> u.getCar().getName())
                .collect(Collectors.toList());
    }

    private static RacingRecords getFinalRacingRecord(List<RacingRecords> racingRecords) {
        return racingRecords.get(racingRecords.size() - 1);
    }

    private static int getRacingMaxPosition(RacingRecords finalRacingHistory) {
        return finalRacingHistory.getRacingRecords()
                .stream()
                .max(Comparator.comparing(RacingRecord::getPosition))
                .orElseThrow(NoSuchElementException::new)
                .getPosition();
    }
}
