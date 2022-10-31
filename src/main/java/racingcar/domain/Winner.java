package racingcar.domain;

import java.util.Objects;

public final class Winner {

    private final String name;

    public Winner(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final Winner winner = (Winner) o;
        return name.equals(winner.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
