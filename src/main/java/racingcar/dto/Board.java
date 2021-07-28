package racingcar.dto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Board {
    List<List<Integer>> racingRecord;
    List<List<CarName>> racingCarNames;

    List<CarName> winnerCarNames;

    public Board() {
        this.racingCarNames = new ArrayList<>();
        this.racingRecord = new ArrayList<>();
        this.winnerCarNames = new ArrayList<>();
    }

    public void record(List<CarName> carNames, List<Integer> carsPositions) {
        racingCarNames.add(carNames);
        racingRecord.add(carsPositions);
    }

    public void recordWinner(List<CarName> winnerCarNames) {
        this.winnerCarNames = winnerCarNames;
    }

    public List<CarName> getWinnerCarNames() {
        return winnerCarNames;
    }

    public List<List<Integer>> getAllRecords() {
        return racingRecord;
    }

    public List<List<CarName>> getAllRecordsCarsNames() {
        return racingCarNames;
    }
}
