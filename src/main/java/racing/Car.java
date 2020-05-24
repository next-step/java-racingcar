package racing;

public class Car {

    private int position;

    public void move(CarMoveBehavior carMoveBehavior) {
        if (carMoveBehavior.action()) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }
}
