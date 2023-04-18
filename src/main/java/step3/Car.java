package step3;

public class Car {
    public static final int MOVE_STANDARD = 4;
    private int location = 0;

    public int move(int numberValue) {
        if (numberValue >= MOVE_STANDARD) {
            return location++;
        }
        return location;
    }

    public int getLocation() {
        return location;
    }

}
