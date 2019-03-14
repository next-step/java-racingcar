package car.entity;

import spark.utils.StringUtils;

public class Car {

    private String name;
    private int movingCount;
    private static final int MOVABLE_MINIMUM_NUM = 3;

    private Car(String name) {
        this.name = StringUtils.isEmpty(name) ? "undefined" : name;
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

    public CarJudgeStatus judgeMaxMovement(int maxMovement) {
        if( maxMovement < movingCount ) {
            return CarJudgeStatus.WIN;
        }

        if( maxMovement == movingCount ) {
            return CarJudgeStatus.DRAW;
        }

        return CarJudgeStatus.LOSE;
    }

    public String getName() {
        return name;
    }

    public int getMovingCount() {
        return movingCount;
    }

    public String toString() {
        StringBuffer carResult = new StringBuffer();
        carResult.append(name+" : ");

        int i = 0;
        while ( i < this.movingCount) {
            carResult.append("-");
            i ++;
        }
        carResult.append("\n");

        return carResult.toString();
    }

    //Testcase 작성을 위해 추가해둠.
    public void setMovingCount(int movingCount) {
        this.movingCount = movingCount;
    }
}
