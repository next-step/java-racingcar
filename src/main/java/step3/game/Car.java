package step3.game;

public class Car {
    private String name;
    private static final int POSSIBLE_MOVE_CONDITION = 4;
    private static final int MAX_MOVE_CONDITION = 9;
    private static final int MIN_MOVE_CONDITION = 0;
    private int position = 0;

    public Car(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 비어있거나 null이 될 수 없습니다.");
        }
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다.");
        }
        this.name = name;
    }

    public void move(int number) {
        if (number > MAX_MOVE_CONDITION || number < MIN_MOVE_CONDITION) {
            throw new IllegalArgumentException("움직일 수 있는 조건을 벗어났습니다. 값 : " + number);
        }
        if (number >= POSSIBLE_MOVE_CONDITION) {
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
