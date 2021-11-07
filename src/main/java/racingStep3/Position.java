package racingStep3;

public class Position {

    private int location;

    public Position(int location) {
        this.location = location;
    }

    public static Position create(int location) {
        return new Position(location);
    }

    public void increaseLocation() {
        location++;
    }

    public int getLocation() {
        return location;
    }

}
