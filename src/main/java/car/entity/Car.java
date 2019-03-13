package car.entity;

public class Car {
    private static final int MOVABLE_MINIMUM_NUM = 3;

    public String name;
    public int movingCount;

    private Car(String name) {
        this.name = name;
        this.movingCount = 0;
    }

    public static Car getCarInstance(String name) {
        return new Car(name);
    }

    public void move(int randomValue) {
        if ( MOVABLE_MINIMUM_NUM < randomValue) {
            movingCount = movingCount+1;
        }
    }

    public void printStatus() {
        System.out.print(name+" : ");

        int i = 0;
        while ( i < this.movingCount) {
            System.out.print("-");
            i ++;
        }

        System.out.println();
    }

    public CarJudgeStatus judgeMaxMovement(int maxMovement) {
        if( maxMovement < movingCount ) {
            return CarJudgeStatus.WIN;
        }

        if( maxMovement == movingCount ) {
            return CarJudgeStatus.DRAW;
        }

        return CarJudgeStatus.LOSE;
    }
}
