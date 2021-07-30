package racingcar.domain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class RacingRecords {

    private final List<RacingRecord> racingRecords = new ArrayList<>();

    public RacingRecords() {
    }

    public void add(RacingRecord racingRecord) {
        racingRecords.add(racingRecord);
    }

    public List<String> getRacingWinner() {
        return racingRecords.stream()
                .filter(u -> u.getPosition() == getRacingMaxPosition())
                .map(u -> u.getCar().getName())
                .collect(Collectors.toList());
    }

    private int getRacingMaxPosition() {
        return racingRecords.stream()
                .max(Comparator.comparing(RacingRecord::getPosition))
                .orElseThrow(NoSuchElementException::new)
                .getPosition();
    }

    public List<RacingRecord> getRacingRecords() {
        return racingRecords;
    }
}
