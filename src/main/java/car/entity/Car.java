package car.entity;

public class Car {
    private static final int MOVABLE_MINIMUM_NUM = 3;

    private int movingCount;

    private Car() {
        movingCount = 0;
    }

    public static Car getCarInstance() {
        return new Car();
    }

    public void move(int randomValue) {
        if ( MOVABLE_MINIMUM_NUM < randomValue) {
            movingCount = movingCount+1;
        }
    }

    public int getMovingCount() {
        return movingCount;
    }
}
