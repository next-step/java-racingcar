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

    private static final int MOVE_CONDITION = 4;     /* 주행 조건 */

    public boolean driving(int driveCondition) {
        boolean isDrive = false;
        if (driveCondition >= MOVE_CONDITION) {
            this.drivingHistory++;
            isDrive = true;
        }
        return isDrive;                              /* 주행 여부 반환 */
    }

    public int getDrivingHistory() {
        return drivingHistory;
    }
}
