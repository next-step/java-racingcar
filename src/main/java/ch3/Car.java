package ch3;

import javax.management.RuntimeErrorException;

public class Car {

    private int position = 0;
    private String name;

    public int getPosition() {
        return position;
    }

    public String name() {
        return name;
    }

    public void move(int number) {
        final int MOVE_CONDITION_NUMBER = 4;
        if (number >= MOVE_CONDITION_NUMBER) {
            this.position++;
        }
    }

    public void makeName(String name) {
        if (name.length() >= 5) {
            throw new RuntimeException("이름은 5자를 초과할 수 없습니다");
        }
        this.name = name;
    }
}
