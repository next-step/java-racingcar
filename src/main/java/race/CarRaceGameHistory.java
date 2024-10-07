package race;

import java.util.Objects;

public class CarRaceGameHistory {
    private final int round;
    private final int step;
    private final String name;

    private CarRaceGameHistory(int round, int step, String name) {
        this.round = round;
        this.step = step;
        this.name = name;
    }

    public static CarRaceGameHistory newInstance(CarRaceGameHistory history) {
        return new CarRaceGameHistory(history.round, history.step, history.name);
    }

    public int getStep() {
        return this.step;
    }

    public int getRound() {
        return this.round;
    }

    public String getName() {
        return this.name;
    }

    public static CarRaceGameHistory record(int round, int step, String name) {
        return new CarRaceGameHistory(round, step, name);
    }

    public boolean isSameStep(int step) {
        return this.step == step;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarRaceGameHistory history = (CarRaceGameHistory) o;
        return round == history.round && step == history.step && Objects.equals(name, history.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(round, step, name);
    }
}
