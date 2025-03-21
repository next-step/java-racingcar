package racing;

public class Car {
    static final int MOVE_THRESHOLD = 4;
    private final String name;
    private int position;

    public Car(String name) {
        if (name == null || name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.");
        }

        this.name = name;
        this.position = 0;
    }

    public void move(int diceValue) {
        if (diceValue >= MOVE_THRESHOLD) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
}
