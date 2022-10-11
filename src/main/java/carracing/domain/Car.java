package carracing.domain;

public class Car {
    private static final int CAN_MOVE_THRESHOLD = 4;
    private int position;
    private String Name;

    public Car(String Name) {
        this.position = 0;
        this.Name = Name;
    }

    public Car(String Name, int position) {
        this.Name = Name;
        this.position = position;
    }

    public void move(int value) {
        if (value > CAN_MOVE_THRESHOLD) {
            this.position += 1;
        }
    }

    public String getName() {
        return Name;
    }

    public int getPosition() {
        return position;
    }
}
