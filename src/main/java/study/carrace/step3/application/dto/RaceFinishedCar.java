package study.carrace.step3.application.dto;

import java.util.List;
import java.util.Objects;

public class RaceFinishedCar {
    private final String name;
    private final List<Boolean> moveStatuses;

    public RaceFinishedCar(String name, List<Boolean> moveStatuses) {
        this.name = name;
        this.moveStatuses = moveStatuses;
    }

    public String getName() {
        return name;
    }

    public List<Boolean> getMoveStatuses() {
        return moveStatuses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RaceFinishedCar that = (RaceFinishedCar) o;
        return Objects.equals(name, that.name) && Objects.equals(moveStatuses, that.moveStatuses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, moveStatuses);
    }
}
