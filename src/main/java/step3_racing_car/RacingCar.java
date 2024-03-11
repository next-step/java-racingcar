package step3_racing_car;

public class RacingCar {
    private int position = 0;
    private String name;

    public RacingCar(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void movePositions(int distance) {
        this.position += distance;
    }
}
