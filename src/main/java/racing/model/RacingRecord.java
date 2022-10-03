package racing.model;

import java.util.ArrayList;
import java.util.List;

public class RacingRecord {
    private List<String> racingRecord;

    public RacingRecord(){
        this.racingRecord = new ArrayList<>();
    }

    public RacingRecord(List<String> racingRecord) {
        this.racingRecord = racingRecord;
    }

    public List<String> getRacingRecord() {
        return racingRecord;
    }

    public void addAll(List<String> records){
        this.racingRecord.addAll(records);
    }
}
