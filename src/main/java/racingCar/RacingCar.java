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

    public CarName findCarName(){
        return this.name;
    }

    public void move(boolean isMovable) {
        if (isMovable) {
            this.location++;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        return sb.append(name.findName())
            .append(" : ")
            .append("-".repeat(Math.max(0, location)))
            .toString();
    }
}
