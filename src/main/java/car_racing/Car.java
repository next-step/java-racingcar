package car_racing;

public class Car {
    private final StringBuilder statusBar;
    private static final String MOVE_FORWARD = "-";

    public Car() {
        this.statusBar = new StringBuilder();
    }

    public void move() {
        if (canGo()) {
            statusBar.append(MOVE_FORWARD);
        }
    }

    public String getCurrStatus() {
        return statusBar.toString();
    }

    private boolean canGo() {
        int randomValue = (int) (Math.random() * 10);
        return randomValue >= 4;
    }



}
