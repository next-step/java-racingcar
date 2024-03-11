package step3.model;

public class Car {
    private static final int MOVE_CONDITION = 4;
    private static final int DEFAULT_MOVE_DISTANCE = 1;
    private int position;

    public Car() {
    }

    public Car(int position) {
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    public void move(int number) {
        if(isMoveCar(number)){
            move();
        }
    }
    private void move() {
        position += DEFAULT_MOVE_DISTANCE;
    }
    private static boolean isMoveCar(int number) {
        return number >= MOVE_CONDITION;
    }
}