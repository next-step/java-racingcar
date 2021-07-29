package study;

public class Car {

    private int position;

    public void moveCar(CarMovingStrategy carMovingStrategy) {
        if (carMovingStrategy.canMoveCar()) {
            position++;
        }
    }

    public int getPosition() {
        return this.position;
    }

}
