package racing;

public class Car implements Comparable<Car> {
    private static final int LIMIT_NAME_LENGTH = 5;     // 자동차 이름 최대 글자수 제한값
    private static final int MIN_MOVE_NUMBER = 4;       // 전진하기 위한 최소 허들 숫자
    private static final String LIMIT_NUMBER_OF_CHARACTERS = "자동차 이름은 5글자를 초과할 수 없습니다.";
    private final String name;
    private final Position position;

    Car(final String name) {
        this(name, new Position());
    }

    Car(final String name, Position position) {
        if (name.length() > LIMIT_NAME_LENGTH) {
            throw new IllegalArgumentException(LIMIT_NUMBER_OF_CHARACTERS);
        }
        this.name = name;
        this.position = position;
    }

    void move(int number) {
        if (number >= MIN_MOVE_NUMBER) {
            position.moveForward();
        }
    }

    @Override
    public int compareTo(Car car) {
        return position.positionOrder(this.position, car.position) * -1;
    }

    String getName() {
        return name;
    }

    int getPosition() {
        return position.getPosition();
    }
}