package game;

public class Car {
    int id;
    int position;
    MovePolicy movePolicy;

    public Car(int id, int position, MovePolicy movePolicy) {
        this.id = id;
        this.position = position;
        this.movePolicy = movePolicy;
    }

    public void move() {
        position = movePolicy.getPosition(position);
    }
}
