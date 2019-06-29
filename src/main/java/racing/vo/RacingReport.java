package racing.vo;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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

    public List<PlayerRecord> getWinners() {

        int longestMileage = records.stream()
                .sorted(Comparator.reverseOrder())
                .findFirst()
                .orElseThrow(IllegalStateException::new)
                .getPosition();

        return records.stream()
                .filter(entryItem -> entryItem.getPosition() >= longestMileage)
                .collect(Collectors.toList());
    }

}
