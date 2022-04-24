package racingcar.racing.repository;

import racingcar.racing.model.RacingRecord;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RacingGameRepository {
    private static final Map<Integer, RacingRecord> store = new HashMap<>();

    private static int sequence = 0;

    public void save(RacingRecord racingRecord) {
        store.put(sequence++, racingRecord);
    }

    public List<RacingRecord> findAllById(int carId) {
        List<RacingRecord> recordList = new ArrayList<>(store.values());

        return recordList.stream()
                .filter(racingRecord -> racingRecord.getCarId() == carId)
                .sorted()
                .collect(Collectors.toList());
    }

    public List<RacingRecord> findAllRacingRecordByTryNumber(int tryNumber) {
        List<RacingRecord> recordList = new ArrayList<>(store.values());

        return recordList.stream()
                .filter(record -> record.getTryNumber() == tryNumber)
                .sorted()
                .collect(Collectors.toList());

    }



    public void clearStore() {
        store.clear();
    }
}
