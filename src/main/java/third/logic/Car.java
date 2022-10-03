package third.logic;


public class Car {

    private static final int THRESHOLD = 4;
    private int carLocation = 1;

    public int getCarLocation() {
        return carLocation;
    }

    public void Move(int number) {
        if (number >= THRESHOLD) {
            carLocation += 1;
        }
    }
}
