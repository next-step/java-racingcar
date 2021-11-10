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

    private String drivingHistory;

    private static final int MOVE_CONDITION = 4;    /* 차량 주행 조건 */

    private static final String RACING_INIT = "";   /* 차량 움직임 초기화 */
    private static final String MOVED = "-";        /* 차량 움직임 */

    public Car() {
        this.drivingHistory = RACING_INIT;          /* 차량 초기화 */
    }

    public void driving(int driveCondition) {
        if (driveCondition >= MOVE_CONDITION) {
            this.drivingHistory = drivingHistory + MOVED;  /* 주행 조건 충족시 주행 */
        }
    }

    public String getDrivingHistory() {
        return drivingHistory;                      /* 주행 이력 가져오기 */
    }
}
