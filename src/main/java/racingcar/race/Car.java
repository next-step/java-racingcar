package racingcar.race;

import racingcar.util.CommonUtil;

public class Car {
    private int position = 0;
    private final String name;

    public Car(String name) {
        CommonUtil.checkNullEmpty(name, "CarName is null or Empty");
        this.name = name;
    }

    public void drive(int count) {
        position += count;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

}
