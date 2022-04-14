package me.devyonghee.racingcar.model;

import me.devyonghee.racingcar.utility.Assert;

import java.util.ArrayList;
import java.util.List;

public final class RacingStadium {

    private final CarPreparer preparer;
    private final int cycleCount;

    private RacingStadium(CarPreparer preparer, int cycleCount) {
        Assert.notNull(preparer, "'preparer' must not be null");
        validateCycleCount(cycleCount);
        this.preparer = preparer;
        this.cycleCount = cycleCount;
    }

    public static RacingStadium of(CarPreparer preparer, int cycleCount) {
        return new RacingStadium(preparer, cycleCount);
    }

    public TracksHistory history() {
        return TracksHistory.from(cycle(preparer.tracks()));
    }

    private List<Tracks> cycle(Tracks tracks) {
        Tracks current = tracks;
        List<Tracks> history = new ArrayList<>();
        for (int i = 0; i < cycleCount; i++) {
            current = current.movedTracks();
            history.add(current);
        }
        return history;
    }

    private void validateCycleCount(int cycleCount) {
        if (cycleCount <= 0) {
            throw new IllegalArgumentException(String.format("'cycleCount'(%d) must be positive", cycleCount));
        }
    }

    @Override
    public String toString() {
        return "RacingStadium{" +
                "preparer=" + preparer +
                ", cycleCount=" + cycleCount +
                '}';
    }
}
