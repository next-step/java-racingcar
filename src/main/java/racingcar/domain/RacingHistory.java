package racingcar.domain;

import java.util.Objects;

public class RacingHistory {
    private final int wrapNumber;
    private final RacingCarStates carStates;

    private RacingHistory(int wrapNumber, RacingCarStates catStates) {
        this.wrapNumber = wrapNumber;
        this.carStates = catStates;
    }

    public static RacingHistory valueOf(int wrapNumber, RacingCarStates catStates) {
        return new RacingHistory(wrapNumber, catStates);
    }

    public int getWrapNumber() {
        return this.wrapNumber;
    }

    public RacingCarStates getCarStates() {
        return this.carStates;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RacingHistory that = (RacingHistory) o;
        return getWrapNumber() == that.getWrapNumber() && Objects.equals(getCarStates(), that.getCarStates());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getWrapNumber(), getCarStates());
    }
}
