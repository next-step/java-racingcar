package racingcar.domain;

import racingcar.dto.Record;
import racingcar.dto.StageRecord;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class RacingFacilitator {

    public static final String WINNER_NAME_DELIMITER = ",";
    private final PositiveNumber racingTryCount;
    private final Racing racing;

    private final List<StageRecord> records = new ArrayList<>();

    public List<StageRecord> processRacing() {
        for (int stage = 0; stage < racingTryCount.getNumber(); stage++) {
            List<Record> records = racing.start();
            writeStageRecord(stage, records);
        }

        return this.records;
    }

    private void writeStageRecord(int stage, List<Record> records) {
        this.records.add(new StageRecord(stage, records));
    }

    public String getWinners() {
        StageRecord finalStageRecord = records
                .stream()
                .reduce((first, second) -> second)
                .orElse(null);

        if (finalStageRecord == null) {
            throw new IllegalStateException("최종 stage record가 없습니다.");
        }

        List<Record> finalRank = finalStageRecord.getRank();
        Record highRecord = finalStageRecord.highRecord();

        return finalRank
                .stream()
                .filter(it -> Objects.equals(it.getMoveCount(), highRecord.getMoveCount()))
                .map(Record::getCarName)
                .collect(Collectors.joining(WINNER_NAME_DELIMITER));
    }

    private RacingFacilitator(PositiveNumber racingTryCount, Racing racing) {
        this.racingTryCount = racingTryCount;
        this.racing = racing;
    }

    public static RacingFacilitator participate(PositiveNumber racingTryCount, List<String> carNames) {
        Racing racing = Racing.create(carNames);

        return new RacingFacilitator(racingTryCount, racing);
    }

    public PositiveNumber getRacingTryCount() {
        return racingTryCount;
    }

    public Racing getRacing() {
        return racing;
    }

    public List<StageRecord> getRecords() {
        return records;
    }
}
