package car;

public class Car {
    private static final int movableMinimumNum = 4;

    private int movingCount;

    public Car() {
        movingCount = 0;
    }

    public void move(int randomValue) {
        if(randomValue >= movableMinimumNum) {
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
