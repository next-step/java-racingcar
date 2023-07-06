package racingcar.car.domain;

/**
 * 자동차 클래스
 */
public class Car {

    private static final int MOVE_THRESHOLD = 4;
    private static final int MOVE_STEP = 1;
    private int position;
    private final Name name;

    public Car(String name) {
        this(0, name);
    }

    public Car(int position, String name) {
        this.position = position;
        this.name = new Name(name);
    }

    /**
     * value 가 4이상이면 자동차를 1만큼 이동시킨다.
     *
     * @param value 자동차를 이동시킬 크기
     */
    public void move(int value) {
        if (value >= MOVE_THRESHOLD) {
            position += MOVE_STEP;
        }
    }

    public String getNameValue() {
        return name.getValue();
    }

    public int getPosition() {
        return position;
    }
}
