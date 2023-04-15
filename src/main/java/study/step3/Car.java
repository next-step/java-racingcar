package study.step3;

import java.security.InvalidParameterException;
import java.util.Random;

public class Car {
    private String name;
    private int position;

    public Car() {
        position = 0;
    }

    public Car(String name) {
        if (name.length() > 5) {
            throw new InvalidParameterException("자동차의 이름은 5글자를 초과할 수 없습니다.");
        }
        this.name = name;
        position = 0;
    }

    public Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public int getPosition() {
        return position;
    }
    public String getName() {
        return name;
    }

    boolean move() {
        if (isExceedStandard(getRandomInt())) {
            position++;
            return true;
        }
        return false;
    }

    boolean isExceedStandard(int num) {
        return num > 3;
    }

    public int getRandomInt() throws IllegalArgumentException {
        Random random = new Random();
        return random.nextInt(10);
    }

    public String printPosition() {
        return name + " : " + "-".repeat(position);
    }

    public void updateInfo(String name, int position) {
        this.name = name;
        this.position = position;
    }
}
