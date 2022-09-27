package step3;

public class Car {
    private int id;
    private int position = 1;

    private final static int LIMIT_POINT_TO_MOVE = 4;

    Car(int id) {
        this.id = id;
    }

    public void move(int point) {
        if (isMovable(point)) {
            this.position++;
        }
    }

    private boolean isMovable(int point) {
        return point >= LIMIT_POINT_TO_MOVE ;
    }

    public int getPosition() {
        return this.position;
    }
}
