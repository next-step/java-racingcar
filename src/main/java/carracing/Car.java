package carracing;

/*
 * Car
 *
 * Version 1.0.0
 *
 * 2021-11-10
 *
 * author jiseok-choi
 */
public class Car {

    private int drivingHistory;

    private static final int MOVE_CONDITION = 4;    /* 주행 조건 */

    public void driving(int driveCondition) {
        if (driveCondition >= MOVE_CONDITION) {
            this.drivingHistory++;
        }
    }

    public int getDrivingHistory() {
        return drivingHistory;
    }
}
