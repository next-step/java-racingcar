package step3.model;

import java.util.Objects;

public class RacingCar {

    private int entryNumber;
    private StringBuilder moveTrack = new StringBuilder();
    private static final String DEFAULT_START_EXPRESSION = "-";

    public RacingCar(int entryNumber){
        this.entryNumber = entryNumber;
        this.moveTrack.append(DEFAULT_START_EXPRESSION);
    }

    public void addCommands(String command){
        moveTrack.append(command);
    }

    public StringBuilder getCommands() {
        return moveTrack;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RacingCar racingCar = (RacingCar) o;
        return entryNumber == racingCar.entryNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(entryNumber);
    }
}
