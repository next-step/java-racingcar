package carRacing.domain;

public class Record {
    private final int round;
    private final String name;
    private final int position;

    public Record(int round, String name, int position) {
        this.round = round;
        this.name = name;
        this.position = position;
    }

    public int getRound() {
        return round;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
