package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class RacingHistories {
    private final List<RacingHistory> value;

    private RacingHistories(List<RacingHistory> histories) {
        this.value = histories;
    }

    public static RacingHistories newInstance(RacingFleet racingFleet) {
        List<RacingHistory> histories = new ArrayList<>();
        histories.add(RacingHistory.valueOf(0, RacingCarStates.valueOf(racingFleet)));
        return new RacingHistories(histories);
    }

    public List<RacingHistory> value() {
        return value;
    }

    public void recordRacingState(RacingFleet racingFleet) {
        RacingCarStates carStates = RacingCarStates.valueOf(racingFleet);
        value.add(RacingHistory.valueOf(findCurrentWrapNo() + 1, carStates));
    }

    private int findCurrentWrapNo() {
        return Collections.max(value, Comparator.comparingInt(RacingHistory::getWrapNumber)).getWrapNumber();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RacingHistories that = (RacingHistories) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }
}
