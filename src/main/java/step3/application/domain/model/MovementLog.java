package step3.application.domain.model;

import java.util.Objects;

public class MovementLog {
    private final String name;
    private final int position;

    public MovementLog(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MovementLog)) return false;
        MovementLog that = (MovementLog) o;
        return position == that.position && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }
}
