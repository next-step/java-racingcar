package racingCar;

import java.util.Random;

public class Car {

    private final int MOVABLE_MIN_NUMBER = 4;
    private final int DRAW_RANGE = 9;
    private static final int CAR_NAME_MAX_LENGTH = 5;
    private static final int INIT_POSITION = 0;
    private final String name;
    private int position;

    public Car(final String name) {
        this(name, INIT_POSITION);
    }

    public Car(final String name, final int position) {
        if (name.length() > CAR_NAME_MAX_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은" + CAR_NAME_MAX_LENGTH + "자를 초과할 수 없습니다.");
        }
        this.name = name;
        this.position = position;
    }

    public void move(int number) {
        if (number >= MOVABLE_MIN_NUMBER) {
            position++;
        }
    }

    public void move() {
        final int draw_number = draw();
        move(draw_number);
    }

    private int draw() {
        return new Random().nextInt(DRAW_RANGE);
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public void showPosition(final String name, final int position) {
        StringBuilder sb = new StringBuilder();
        System.out.print(name + " : ");
        for (int i = 0; i < position; i++) {
            sb.append("-");
        }
        System.out.println(sb.toString());
    }
}