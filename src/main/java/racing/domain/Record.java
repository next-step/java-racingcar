package racing.domain;

public class Record {

    private final String name;

    private final int position;

    public Record(Car car) {
        this.name = car.getName();
        this.position = car.getPosition().getPosition();
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
