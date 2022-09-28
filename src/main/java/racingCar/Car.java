package racingCar;


import java.util.Random;

public class Car implements Comparable<Car> {
    private static final int MOVE_NUM = 4;
    private static final int RANDOM_BOUND = 10;
    private static final String ERR_MSG_NAME_LENGTH = "이름은 5글자를 초과할 수 없습니다.";
    public static final int NAME_LEN_BOUND = 5;
    private int pos;
    private final String name;

    public Car(String name) {
        if (name.length() > NAME_LEN_BOUND) {
            throw new RuntimeException(ERR_MSG_NAME_LENGTH);
        }
        this.pos = 0;
        this.name = name;
    }

    public Car(int pos, String name) {
        this.pos = pos;
        this.name = name;
    }

    public int getPos() {
        return pos;
    }

    private void move(int num) {
        if (num >= MOVE_NUM) {
            this.pos++;
        }
    }

    public void play(Random random) {
        move(random.nextInt(RANDOM_BOUND));
    }


    public String getName() {
        return this.name;
    }

    @Override
    public int compareTo(Car o) {
        return o.pos - this.pos;
    }
}
