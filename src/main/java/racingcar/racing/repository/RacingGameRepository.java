package racingcar.racing.repository;

import racingcar.racing.RacingCar;
import racingcar.racing.RacingRecord;

import java.util.*;
import java.util.stream.Collectors;

public class RacingGameRepository {
    private static final Map<Integer, RacingRecord> store = new HashMap<>();

    private int sequence = 0;

    public void save(RacingCar racingCar, int tryNumber) {
        RacingRecord record= new RacingRecord(racingCar.getId(), racingCar.getxCoordinate(), tryNumber);
        store.put(sequence++, record);
    }

    public List<RacingRecord> findAllById(int carId) {
        List<RacingRecord> recordList = new ArrayList<>(store.values());

        return recordList.stream()
                .filter(racingRecord -> racingRecord.getCarId() == carId)
                .sorted(Comparator.comparing(RacingRecord::getCarId))
                .collect(Collectors.toList());
    }

    public List<RacingRecord> findAllByTryNumber(int tryNumber) {
        List<RacingRecord> recordList = new ArrayList<>(store.values());

        return recordList.stream()
                .filter(record -> record.getTryNumber() == tryNumber)
                .sorted(Comparator.comparing(RacingRecord::getCarId))
                .collect(Collectors.toList());

    }


    public void clearStore() {
        store.clear();
    }
}
