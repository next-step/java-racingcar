package race.logic;

public class RaceScore {
    private final String name;
    private final int position;

    RaceScore(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
