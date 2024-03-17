package racing.domain;

public class Car {
    private static final int MAX_NAME_LENGTH = 5;
    private static final int INIT_POSITION = 0;
    private int position;
    private final String name;

    public Car(String name) {
        checkNameLength(name);
        this.position = INIT_POSITION;
        this.name = name;
    }

    public static Car withName(String name) {
        checkNameLength(name);
        return new Car(name);
    }

    public int forward(MoveStrategy moveStrategy) {
        if (moveStrategy.isMovable()) {
            position++;
        }
        return position;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Car{" +
                "position=" + position +
                '}';
    }

    private static void checkNameLength(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("이름을 입력하세요");
        }
        if (MAX_NAME_LENGTH < name.length()) {
            throw new IllegalArgumentException("이름의 길이는 5자를 초과 할 수 없습니다.");
        }
    }
}
