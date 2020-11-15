package race.logic;

public class LapScore {
    private final String name;
    private final int position;

    LapScore(String name, int position) {
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
