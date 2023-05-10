package carracing.domain;

public class Location {

    private int location;

    public Location() {
        this.location = 0;
    }

    public int get() {
        return location;
    }

    public void plus() {
        location++;
    }
}
