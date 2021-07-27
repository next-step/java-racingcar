package racingcar.dto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Board {
    List<List<Integer>> racingRecord;
    List<List<String>> racingCarNames;

    List<String> winnerCarNames;

    public Board() {
        this.racingCarNames = new ArrayList<>();
        this.racingRecord = new ArrayList<>();
        this.winnerCarNames = new ArrayList<>();
    }

    public void record(List<String> carNames, List<Integer> carsPositions) {
        racingCarNames.add(carNames);
        racingRecord.add(carsPositions);
    }

    public void recordWinner(List<String> winnerCarNames) {
        this.winnerCarNames = winnerCarNames;
    }

    public List<String> getWinnerCarNames() {
        return winnerCarNames;
    }

    public List<List<Integer>> getAllRecords() {
        return racingRecord;
    }

    public List<List<String>> getAllRecordsCarsNames() {
        return racingCarNames;
    }
}
