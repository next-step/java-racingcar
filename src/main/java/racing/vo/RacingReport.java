package racing.vo;

import java.util.List;

/**
 * 레이싱 결과 정보를 전달하는 모델객체
 */
public class RacingReport {

    private static final int END_OF_ROUNDS = 0;

    private List<PlayerRecord> records;

    private int remainRound;

    public RacingReport(List<PlayerRecord> records, int remainRound){

        this.records = records;

        this.remainRound = remainRound;
    }

    public List<PlayerRecord> getRecords(){
        return records;
    }

    public boolean hasNext(){
        return remainRound > END_OF_ROUNDS;
    }
}
