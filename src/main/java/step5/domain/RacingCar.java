package step5.domain;

public class RacingCar {

    private String carName;
    private int position;

    public RacingCar(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException();
        }
        this.carName = carName;
    }

    public int run(RandomNo randomNo) {
        if (randomNo.isMovable()) position++;
        return position;
    }

    public String getCarName() {
        return carName;
    }

    public int getPosition() {
        return position;
    }
}
