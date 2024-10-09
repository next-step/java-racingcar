package racingcar.domain;

public class Record {

    private final int position;
    private final String name;

    public Record(int position, String name) {
        this.position = position;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}