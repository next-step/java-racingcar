package step3;

public class Car {
    private int no;

    private int movingDistance = 0;

    public Car(int no) {
        this.no = no;
    }

    public int getMovingDistance() {
        return this.movingDistance;
    }

    public void moveIf(MoveCondition condition) {
        if (condition.match()) movingDistance++;
    }

    public void displayOn(RaceDisplay raceDisplay) {
        raceDisplay.writeMovingDistance(no, movingDistance);
    }
}
