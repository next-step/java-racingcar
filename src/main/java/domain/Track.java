package domain;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Random;

public class Track {

    private static final Random RANDOM = new Random();
    private static final int BOUND = 10;
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
                .forEach(racingCar -> racingCar.race(RANDOM.nextInt(BOUND)));
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
