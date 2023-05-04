package study.race;

import java.util.Random;

public class Car {

    //프로그래밍 상에서 의미가 있고 기준이 되는 값은 필드값으로 처리하는 것이 좋음.

    private static final int MOVING_NUM = 4;
    private int position = 0;
    private int BOUND = 10;
    private String name;

    public int getPosition() {
        return this.position = position;
    }

    public String getName() {
        return this.name = name;
    }

    public Car(String name) {
        this.name = name;
    }

    public Car(String name, int position) {
        if (name.length() > 6) {
            throw new StringIndexOutOfBoundsException("String index out of range: 5");
        }
        this.name = name;
        this.position = position;
    }

    void move() {
        Random random = new Random();
        if (random.nextInt(BOUND) >= MOVING_NUM) {
            this.position++;
        }
    }

    @Override
    public String toString() {
        return "Car{" +
                "BOUND=" + BOUND +
                ", position=" + position +
                ", name='" + name + '\'' +
                '}';
    }

    boolean winnerCheck(int maxPosition) {
        if (maxPosition == this.position) {
            return true;
        }
        return false;
    }

    int max(int position) {
        if (position < this.position) {
            return this.position;
        }
        return position;
    }
}
