package racingcar;

public class Car {
    private static final int MOVABLE_THRESHOLD = 4;
    private static final int MAX_NM_LEN = 5;

    private int position = 0;
    private String name;

    public void moveForward(int input) {
        if (input >= MOVABLE_THRESHOLD) {
            this.position++;
        }
    }

    public int getPosition() {
        return this.position;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        if (name.length() > MAX_NM_LEN) {
            throw new RuntimeException("자동차명은 5글자를 넘길 수 없습니다 : " + name);
        }
        this.name = name;
    }
}
