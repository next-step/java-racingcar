package racing.domain;

import java.util.Objects;

public class Player {
    private final int NAME_LENGTH_LIMIT = 5;

    private final String name;

    public Player(String name) throws CarNameException {
        validate(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void validate(String name) throws CarNameException {
        if (name.length() > getLimitValue()) {
            throw new CarNameException();
        }
    }

    protected int getLimitValue() {
        return NAME_LENGTH_LIMIT;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return NAME_LENGTH_LIMIT == player.NAME_LENGTH_LIMIT && Objects.equals(name, player.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(NAME_LENGTH_LIMIT, name);
    }
}
