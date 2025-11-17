package racinggame.domain;

import java.util.Objects;

public class RaceResult {
    private final String name;
    private final int position;

    public RaceResult(String name, int position) {
        this.name = name;
        this.position = position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RaceResult that = (RaceResult) o;
        return position == that.position && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }

    @Override
    public String toString() {
        return "RoundSnapshot{" +
                "name='" + name + '\'' +
                ", position=" + position +
                '}';
    }
}
