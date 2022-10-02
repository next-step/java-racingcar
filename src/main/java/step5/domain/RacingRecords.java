package step5.domain;

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

        // maxPosition을 찾는다.
        Position betterPosition = new Position(0);
        for(RacingRecord racingRecord : racingRecords){
            betterPosition = racingRecord.greaterOrEqualPosition(betterPosition);
        }

        // bestRecords를 찾는다.
        Position maxPosition = betterPosition;
        List<RacingRecord> bestRecords = this.racingRecords.stream()
                .filter(racingRecord -> racingRecord.hasSamePosition(maxPosition))
                .collect(Collectors.toList());

        // records로부터 이름을 추출한다.
        return bestRecords.stream()
                .map(record -> record.getCarName())
                .collect(Collectors.toList());
    }

}
