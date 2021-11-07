package step3.domain;

import step3.utils.RandomUtils;

public class Car {
    private static final String DASH = "-";
    private static final int MOVE_CONDITION = 4;
    private int position;

    protected Car() {
        this.position = 0;
    }

    public static Car create() {
        return new Car();
    }

    public void move() {
        if (isMove()) {
            position++;
        }
    }

    protected boolean isMove() {
        return RandomUtils.nextInt() >= MOVE_CONDITION;
    }

    public void showPositionToDash() {
        System.out.println(repeatDash());
    }

    private String repeatDash() {
        StringBuilder sb = new StringBuilder();
        for (int count = 0; count < position; count++) {
            sb.append(DASH);
        }
        return sb.toString();
    }

    public int getPosition() {
        return this.position;
    }
}
