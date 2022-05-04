package racingcar.v1.repository;

import racingcar.v1.domain.RacingRecord;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class RacingGameRepository {
    private static final Map<Integer, RacingRecord> store = new HashMap<>();

    private static final AtomicInteger sequence  = new AtomicInteger(0);

    public synchronized void save(RacingRecord racingRecord) {
        store.put(sequence.getAndIncrement(), racingRecord);
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
