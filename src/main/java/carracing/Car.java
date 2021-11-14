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
    private String name;

    private static final int MOVE_CONDITION = 4;         /* 주행 조건 */
    private static final int MOVE_CONDITION_MIN = 0;     /* 최소 주행 범위 */
    private static final int MOVE_CONDITION_MAX = 9;     /* 최대 주행 범위 */
    private static final int CAR_NAME_CONDITION = 5;     /* 최대 주행 범위 */

    String ERR_MSG_CONDITION_RANGE = "주행 조건은 0 ~ 9 사이 값 입니다.";
    String ERR_MSG_CONDITION_CAR_NAME = "차 이름 길이는 5 이하의 값 입니다.";

    public Car() {
    }

    public Car(String name) throws CarNameFormatException {
        carNameValid(name);
        this.name = name;
    }

    public boolean driving(int driveCondition) {
        boolean isDrive = false;

        driveValid(driveCondition);
        if (driveCondition >= MOVE_CONDITION) {
            this.drivingHistory++;
            isDrive = true;
        }
        return isDrive;                              /* 주행 여부 반환 */
    }

    public void driveValid(int driveCondition) {
        if (MOVE_CONDITION_MAX < driveCondition || MOVE_CONDITION_MIN > driveCondition) {
            throw new NumberFormatException(ERR_MSG_CONDITION_RANGE);
        }
    }

    public void carNameValid(String carName) throws CarNameFormatException {
        if (CAR_NAME_CONDITION < carName.length()) {
            throw new CarNameFormatException(ERR_MSG_CONDITION_CAR_NAME);
        }
    }

    public int getDrivingHistory() {
        return drivingHistory;
    }

    public String getName() {
        return name;
    }
}
