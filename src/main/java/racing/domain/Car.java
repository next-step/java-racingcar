package racing.domain;

public class Car {
    private final static int RACING_CONDITION = 4;
    private final static String GO_DELIMETER = "-";

    private StringBuilder moved;

    public Car() {
        this.moved = new StringBuilder();
    }

    public String getMoved() {
        return moved.toString();
    }

    public void move(int movable) {
        if(RACING_CONDITION <= movable) {
            moved.append(GO_DELIMETER);
        }
    }

}
