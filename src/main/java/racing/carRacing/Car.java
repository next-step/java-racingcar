package racing.carRacing;

public class Car {
    public static final int CONDITION = 5;
    public static final int FIRST_POSITION = 0;

    private int position;
    private String name;

    public Car(String name) {
        position = FIRST_POSITION;
        checkWrongString(name);
        this.name = name;
    }

    public Car(int position) {
        this.position = position;
    }

    private void checkWrongString(String name) {
        isNullOrEmpty(name);
        isWrongLength(name);
    }

    private void isNullOrEmpty(String name) {
        if (isNull(name) || isEmpty(name)) {
            throw new IllegalArgumentException("자동차 이름을 입력해주세요");
        }
    }

    private boolean isNull(String name) {
        return name == null;
    }

    private boolean isEmpty(String name) {
        return name.isEmpty();
    }

    private void isWrongLength(String name) {
        if (name.length() > CONDITION) {
            throw new IllegalArgumentException("자동차 이름은 5글자 이상 초과할 수 없습니다.");
        }
    }

    public void run(MovementStrategy strategy) {
        if (strategy.movement()) {
            position++;
        }
    }

    public int getCurrentPosition() {
        return position;
    }

    public String getCurrentCar() {
        return name;
    }

    public boolean getMaxPosition(int maxPosition) {
        return position == maxPosition;
    }
}
