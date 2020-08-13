package racing.core;

public class Car {

    public static final int CONDITION = 4;
    private int position;

    public Snapshot move(int random) {
        return new Snapshot(random >= CONDITION ? ++position : position);
    }
}
