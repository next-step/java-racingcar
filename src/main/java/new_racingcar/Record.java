package new_racingcar;

public class Record {
    private int distance;

    public Record() {
        this.distance = 0;
    }

    public void addDistance() {
        ++this.distance;
    }

    public int getDistance() {
        return this.distance;
    };
}
