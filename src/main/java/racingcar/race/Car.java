package racingcar.race;

import racingcar.util.CommonUtil;

public class Car {
    private final static int DEFAULT_POSITION = 0;
    private final String name;
    private int position;

    public Car(String name, int position) {
        CommonUtil.checkNullEmpty(name, "CarName is null or Empty");
        this.name = name;
        this.position = position;
    }

    public static Car newInstance(String name) {
        return new Car(name, DEFAULT_POSITION);
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
