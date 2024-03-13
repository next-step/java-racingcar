package racingCar;

public class RacingCar {

    private static final int START_LOCATION = 0;
    private CarName name;
    private int location;

    public RacingCar() {
        this.location = START_LOCATION;
    }

    public RacingCar(CarName name) {
        this.name = name;
        this.location = START_LOCATION;
    }

    public int findCurrentLocation() {
        return this.location;
    }

    public void move(boolean isMovable) {
        if (isMovable) {
            this.location++;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < location; i++) {
            sb.append("-");
        }
        return sb.toString();
    }
}
