package racing;

public class Car {
//    private CarMoveBehavior carMoveBehavior;
    private int position;

//    public Car(CarMoveBehavior carMoveBehavior) {
//        this.carMoveBehavior = carMoveBehavior;
//    }

    public int move(CarMoveBehavior carMoveBehavior) {
        if (carMoveBehavior.action()) {
            position++;
        }
        return position;
    }

    public int getPosition() {
        return position;
    }
}
