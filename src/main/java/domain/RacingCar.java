package domain;

public class RacingCar {

    private int position;

    private RacingCar() {}

    public static RacingCar init() {

        return new RacingCar();
    }

    public void move() {

        this.position++;
    }

    public int getPosition() {

        return this.position;
    }
}