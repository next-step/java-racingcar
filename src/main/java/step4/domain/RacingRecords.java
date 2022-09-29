package step4.domain;

import java.util.List;
import java.util.stream.Collectors;

public class RacingRecords {

    private List<RacingRecord> racingRecords;

    public RacingRecords(List<RacingRecord> racingRecords) {
        this.racingRecords = racingRecords;
    }

    public List<RacingRecord> getRacingRecords() {
        return this.racingRecords;
    }

    public List<String> firstRacingCars(){
        return this.racingRecords.stream()
                .filter(racingRecord -> racingRecord.getPosition() == maxPosition())
                .map(racingRecord -> racingRecord.getCarName())
                .collect(Collectors.toList())
                ;
    }

    private int maxPosition() {
        return this.racingRecords.stream()
                .mapToInt(racingRecord -> racingRecord.getPosition())
                .max()
                .orElse(0);
    }
}
