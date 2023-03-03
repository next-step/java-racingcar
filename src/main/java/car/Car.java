package car;

import java.util.Random;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name, int position) {
        checkName(name);
        this.name = name;
        this.position = position;
    }

    public Car(String name) {
        checkName(name);
        this.name = name;
    }

    public void printPositionStatus() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < position; i++) {
            sb.append("-");
        }
        System.out.println(this.name + " : " + sb.toString());
    }

    public void move(int randomValue) {
        if (randomValue >= 4) {
            this.position++;
        }
        printPositionStatus();
    }

    private void checkPosition(int count) {
        if (count > 0) throw new IllegalArgumentException("이동할 횟수는 0 이상이여야 합니다. count = " + count);
    }

    private void checkName(String name) {
        if (name.length() >= 5) throw new IllegalArgumentException("자동차 이름은 5자 미만만 가능 합니다. name = " + name);
    }

    public int getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
