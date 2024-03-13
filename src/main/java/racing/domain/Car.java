package racing.domain;

public class Car {

    private static final int ZERO = 0;
    private int position;
    private final String name;

    public Car(String name) {
        this.position = ZERO;
        this.name = name;
    }

    public int forward(MoveStrategy moveStrategy) {
        //position ++ <- 코드좀 정리하숑

        if (moveStrategy.isMovable()) {
            position++;
        }
        return position;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return "Car{" +
                "position=" + position +
                '}';
    }
}
