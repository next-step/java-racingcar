package study.step3.domain;

import java.util.*;
import java.util.function.BiConsumer;

import static java.util.stream.Collectors.toSet;

public class RaceRecord {
    private final Map<String, List<Boolean>> records = new TreeMap<>();
    private final List<Car> carRecords = new ArrayList<>();

    public void saveRecord(Car car) {
        records.computeIfAbsent(car.getName(), key -> new ArrayList<>()) //
                .add(car.isMoved());
        carRecords.add(car);
    }

    public int getTotalTry() {
        if (records.isEmpty()) {
            return 0;
        }

        int totalTry = records.values().iterator().next().size();

        checkAllRecord(totalTry);

        return totalTry;
    }

    public Set<String> listMostMovingNames() {
        int mostMove = getMostMove();
        return carRecords.stream() //
                .filter(car -> car.getDistanceDriven() >= mostMove) //
                .map(Car::getName) //
                .collect(toSet());
    }

    public void forEachRecordUntil(int tries, BiConsumer<String, List<Boolean>> biConsumer) {
        records.forEach((name, record) -> biConsumer.accept(name, record.subList(0, tries)));
    }

    private int getMostMove() {
        return carRecords.stream() //
                .mapToInt(Car::getDistanceDriven) //
                .max() //
                .orElse(0);
    }

    private int countMove(List<Boolean> values) {
        return values.stream().mapToInt(moved -> moved ? 1 : 0).sum();
    }

    private void checkAllRecord(int expectedTry) {
        records.values() //
                .stream() //
                .map(List::size) //
                .forEach(tries -> throwIfNotEqual(expectedTry, tries));
    }

    private void throwIfNotEqual(int expectedTry, int tries) {
        if (expectedTry != tries) {
            throw new IllegalStateException("모든 자동차의 이동시도횟수 기록은 동일해야 합니다.");
        }
    }
}
