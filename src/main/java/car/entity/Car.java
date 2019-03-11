package car.entity;

public class Car {
    private static final int MOVABLE_MINIMUM_NUM = 4;

    private int movingCount;

    public Car() {
        movingCount = 0;
    }

    public void move(int randomValue) {
        if(randomValue >= MOVABLE_MINIMUM_NUM) {
            movingCount = movingCount+1;
        }
    }

    public void printStatus() {
        for( int i=0; i < movingCount; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public int getMovingCount() {
        return movingCount;
    }
}
