package racingcar;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class Track {

    private final RacingCar[] entries;
    private final int rounds;

    public Track(String[] names, int rounds) {
        this.entries = Arrays.stream(names)
                .map(RacingCar::new)
                .toArray(RacingCar[]::new);
        this.rounds = rounds;
    }

    public RacingCar[] getEntries() {
        return entries.clone();
    }

    public int getRounds() {
        return rounds;
    }

    public void race() {
        Arrays.stream(entries)
                .forEach(RacingCar::race);
    }

    public String[] getWinners() {
        int winningLaps = Arrays.stream(entries)
                .map(RacingCar::record)
                .max(Integer::compare)
                .orElseThrow(NoSuchElementException::new);
        return Arrays.stream(entries)
                .filter(racingCar -> racingCar.record() >= winningLaps)
                .map(RacingCar::getName)
                .toArray(String[]::new);
    }
}
