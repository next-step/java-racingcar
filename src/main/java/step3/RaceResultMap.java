package step3;

public class RaceResultMap {
    int position;

    public RaceResultMap(int position) {
        this.position = position;
    }

    public RaceResultMap(Car car) {
        this(0);
    }

    @Override
    public String toString() {
        return "-".repeat(position + 1);
    }

    public RaceResultMap withResult() {
        return new RaceResultMap(position);
    }
}
