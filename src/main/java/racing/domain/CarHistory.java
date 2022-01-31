package racing.domain;

public class CarHistory {

    private final Name name;
    private final int position;

    public CarHistory(Name name, int position) {
        this.name = new Name(name);
        this.position = position;
    }

    public Name getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
