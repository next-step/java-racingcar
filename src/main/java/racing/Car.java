package racing;

public class Car {
    private String carName;
    private int position;

    public void move(CarMoveBehavior carMoveBehavior) {
        if (carMoveBehavior.action()) {
            position++;
        }
    }

    public String getCarName() {
        return carName;
    }

    public int getPosition() {
        return position;
    }
}
