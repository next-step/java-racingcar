package carracing.util;

import carracing.exception.CarNameFormatException;

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

    private static final int MOVE_CONDITION = 4;         /* 주행 조건 */
    private static final int MOVE_CONDITION_MIN = 0;     /* 최소 주행 범위 */
    private static final int MOVE_CONDITION_MAX = 9;     /* 최대 주행 범위 */

    private static final String ERR_MSG_CONDITION_RANGE = "주행 조건은 0 ~ 9 사이 값 입니다.";

    private Position position;
    private Name name;

    public Car(String name) throws CarNameFormatException {
        this.position = new Position();
        this.name = new Name(name);
    }

    public boolean driving(int driveCondition) {
        driveValid(driveCondition);
        if (driveCondition >= MOVE_CONDITION) {
            this.position.move();
            return true;
        }
        return false;                              /* 주행 여부 반환 */
    }

    public void driveValid(int driveCondition) {
        if (MOVE_CONDITION_MAX < driveCondition || MOVE_CONDITION_MIN > driveCondition) {
            throw new NumberFormatException(ERR_MSG_CONDITION_RANGE);
        }
    }

    public int getPosition() {
        return position.getPosition();
    }

    public Name getName() {
        return name;
    }
}
