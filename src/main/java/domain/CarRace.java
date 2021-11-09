package domain;

public class CarRace {
    private final String car;
    private final int position;

    public CarRace(String car, int position) {
        this.car = car;
        this.position = position;
    }

    public String getCar() {
        return car;
    }

    public int getPosition() {
        return position;
    }
}
