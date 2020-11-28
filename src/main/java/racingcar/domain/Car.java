package racingcar.domain;

import java.util.List;
import java.util.Map;

public class Car {

    private final static int MAX_NAME_LENGTH = 5;
    private final static int MOVE_POINT = 4;
    private final static int START_LOCATION = 1;

    private int location;
    private final String name;

    private Car(String name) {
        this.location = START_LOCATION;
        this.name = name;
    }

    public static Car newCar(String name) {
        validateName(name);
        return new Car(name);
    }

    private static void validateName(String name) {
       if (name.length() > MAX_NAME_LENGTH)
           throw new IllegalArgumentException("자동차 이름은 " + MAX_NAME_LENGTH +"자 이하로 입력해주세요 :)");
    }

    public int getLocation() {
        return location;
    }

    public String getName() {
        return name;
    }

    private void move() {
        location++;
    }

    public void tryToMove(int randomNumber) {
        if (randomNumber >= MOVE_POINT) {
            move();
        }
    }

    public boolean isContained(List<String> list) {
        return list.contains(name);
    }

    public void saveLocation(Map<String, Integer> map) {
        map.put(name, location);
    }
}
