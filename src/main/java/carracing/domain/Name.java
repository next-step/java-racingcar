package carracing.domain;

import carracing.exception.CarNameFormatException;

public class Name {

    String ERR_MSG_CONDITION_CAR_NAME = "차 이름 길이는 1이상 5 이하의 값 입니다. err name = {}";
    private static final int CAR_NAME_CONDITION_MIN = 1;     /* 최소 자동차 이름 길이 */
    private static final int CAR_NAME_CONDITION_MAX = 5;     /* 최대 자동차 이름 길이 */

    private final String alias;

    public Name(String name) throws CarNameFormatException {
        carNameValid(name);
        this.alias = name;
    }

    public void carNameValid(String carName) throws CarNameFormatException {
        int nameSize = carName.length();
        if (CAR_NAME_CONDITION_MAX < nameSize || CAR_NAME_CONDITION_MIN > nameSize) {
            throw new CarNameFormatException(String.format(ERR_MSG_CONDITION_CAR_NAME, carName));
        }
    }

    public String getAlias() {
        return alias;
    }
}
