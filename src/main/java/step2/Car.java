package step2;

public class Car {
    private final static int INITIAL_POSITION = 0;
    private final static int DISTANCE_PER_MOVE = 1; //TODO: 상수들은 Car를 사용하는 곳에서 선언해야되려나?

    private int position;

    public Car() {
        this.position = INITIAL_POSITION;
    }

    private Car(int position) {
        this.position = position;
    }

    public int getPosition() {
        return this.position;
    }

//    public int move() {
//        return this.position + DISTANCE_PER_MOVE;
//    }

    public Car move(int distancePerMove) {
        return new Car(this.position + distancePerMove);
    }
}
