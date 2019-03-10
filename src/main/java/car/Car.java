package car;

public class Car {
    private int movingCount;

    public Car() {
        movingCount = 0;
    }

    public void setStatus(int randomValue) {
        if(randomValue >= 4 ) {
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
