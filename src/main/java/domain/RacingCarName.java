package domain;

import java.util.Objects;

public class RacingCarName {

    private final String name;

    private RacingCarName(String name) {
        this.name = name;
    }

    public static RacingCarName newInstance(String name) {
        if (name == null || "".equals(name.trim())) {
            throw new IllegalArgumentException("car name is null or empty.");
        }

        return new RacingCarName(name);
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RacingCarName)) return false;
        RacingCarName that = (RacingCarName) o;
        return Objects.equals(getName(), that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}
