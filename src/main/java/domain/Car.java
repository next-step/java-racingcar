package domain;

public class Car {

    private final static int RANDOM_BOUND = 10;
    private final static int MOVE_BOUND = 4;
    private final static int MOVE_STEP = 1;

    private String name;
    private int position;

    public Car(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 비어 있을 수 없습니다");
        }

        if (name.trim().length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다");
        }

        this.name = name.trim();
    }

    /**
     * 자동차를 앞으로 전진시킵니다.
     */
    public void move(int randomNo) {
        if (randomNo >= MOVE_BOUND) {
            this.position += MOVE_STEP;
        }
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
}
