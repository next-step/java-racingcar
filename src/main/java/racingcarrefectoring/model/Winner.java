package racingcarrefectoring.model;

public class Winner {

    private final Name name;

    public Winner(Name name){
        this.name = name;
    }

    public Name getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Winner winner = (Winner) o;

        return name != null ? name.equals(winner.name) : winner.name == null;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}
