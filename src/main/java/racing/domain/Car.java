package racing.domain;

public class Car {

    private static final int ZERO = 0;
    private int position;

    public Car() {
        this.position = ZERO;
    }

    public int forward(MoveStrategy moveStrategy) {
        //position ++

        if(moveStrategy.isMovable()){
            position ++;
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
