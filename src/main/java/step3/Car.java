package step3;

public class Car {

    private Dashboard dashboard;

    private final int MOVEMENT_CONDITION = 3;
    private final int MOVEMENT_DISTANCE = 1;

    public Car() {
        this.dashboard = new Dashboard();
    }

    public Dashboard getDashboard() {
        return dashboard;
    }

    public void accelerate(int number) {
        if (isMovable(number)) {
            move(MOVEMENT_DISTANCE);
        }
    }

    private void move(int distance) {
        getDashboard().addMileage(distance);
    }

    private boolean isMovable(int number) {
        return number > MOVEMENT_CONDITION;
    }
}
