package step3;

import java.util.stream.IntStream;

public class Car {
    private int id;
    private int position = 1;

    final static int LIMIT_POINT_TO_MOVE = 4;

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

    public String getPositionString() {
        StringBuilder positionString = new StringBuilder();
        IntStream.range(0, position).forEach(vo -> positionString.append("-"));
        return positionString.toString();
    }
}
