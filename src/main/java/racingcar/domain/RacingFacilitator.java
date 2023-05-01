package racingcar.domain;

import racingcar.dto.Record;
import racingcar.dto.StageRecord;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class RacingFacilitator {

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

    public List<Record> getWinners() {
        StageRecord finalStageRecord = records
                .stream()
                .max(Comparator.comparing(StageRecord::getStage))
                .orElseThrow(() -> new IllegalStateException("최종 stage record가 없습니다."));

        List<Record> finalRank = finalStageRecord.getRank();
        Record highRecord = finalStageRecord.highRecord();

        return finalRank
                .stream()
                .filter(it -> Objects.equals(it.getMoveCount(), highRecord.getMoveCount()))
                .collect(Collectors.toList());
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
