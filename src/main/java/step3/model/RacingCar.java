package step3.model;

import java.util.Objects;

public class RacingCar {

    private int entryNumber;
    private StringBuilder commands = new StringBuilder();
    private static final String DEFAULT_EXPRESSION = "-";

    public RacingCar(int entryNumber){
        this.entryNumber = entryNumber;
        commands.append(DEFAULT_EXPRESSION);
    }

    public void addCommands(String command){
        commands.append(command);
    }

    public StringBuilder getCommands() {
        return commands;
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
