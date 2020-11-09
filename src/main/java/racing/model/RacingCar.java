package racing.model;

public class RacingCar implements Car {

    private static final int MOVEABLE_NUMBER = 4;
    private int location = 0;

    @Override
    public void move(int fuel) {
        if (MOVEABLE_NUMBER <= fuel) {
            location++;
        }
    }

    @Override
    public int currentLocation() {
        return location;
    }
}
