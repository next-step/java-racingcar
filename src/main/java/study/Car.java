package study;

import java.util.Random;

public class Car {

    private String name;
    private int position = 0;

    public Car(String name) {
        this(name, 0);
    }

    public Car(String name, int position) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.");
        }
        this.name = name;
        this.position = position;
    }

    public void move() {
        if(new Random().nextInt(10) > 4) {
            position++;
        }
    }

    public void print() {
        for (int i = 0; i <position ; i++) {
            System.out.print("-");
        }
        System.out.println("");
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return "Car{" +
            "name='" + name + '\'' +
            ", position=" + position +
            '}';
    }

    public boolean isWinner(int maxPosition) {
        return position == maxPosition;
    }

    public int max(int otherPosition) {
        if (position > otherPosition) {
            return position;
        }
        return otherPosition;
    }
}
