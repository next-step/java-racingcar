package race.car;

public class Location {
    private int location = 0;

    public void moveOnePoint() {
        this.location += 1;
    }

    int location() {
        return this.location;
    }
}
