package racing.domain;

public class Location {
    public int number;

    public Location() {
        this.number = 0;
    }

    public int forward() {
        return this.number++;
    }
}
