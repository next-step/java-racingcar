package racingcar;

public class Car {
    private static final int MOVE_STANDARD = 4;
    private static final int DEFAULT_DISTANCE = 1;

    private final String name;
    private int position;

    public Car(String name, int position) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름의 길이를 5 이하로 입력해주세요.");
        }
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return this.name;
    }

    public void move(int number) {
        if (number >= MOVE_STANDARD) {
            this.position += DEFAULT_DISTANCE;
        }
    }

    public int getPosition() {
        return this.position;
    }

    public int getMax(int max) {
        return Math.max(max, this.position);
    }

    public boolean isMaxPosition(int max) {
        return this.position == max;
    }

}
