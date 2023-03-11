package racing;

public class Car implements Comparable<Car> {
    private static final int LIMIT_NAME_LENGTH = 5;     // 자동차 이름 최대 글자수 제한값
    private static final int DEFAULT_POSITION = 0;      // 디폴트값
    private static final int MIN_MOVE_NUMBER = 4;       // 전진하기 위한 최소 허들 숫자
    private final String name;
    private int position;

    Car(final String name) {
        this(name, DEFAULT_POSITION);
    }

    Car(final String name, int position) {
        if (name.length() > LIMIT_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 5글자를 초과할 수 없습니다.");
        }
        this.name = name;
        this.position = position;
    }

    void move(int number) {
        if (number >= MIN_MOVE_NUMBER) {
            position++;
        }
    }

    @Override
    public int compareTo(Car car) {
        return (this.getPosition() - car.getPosition()) * -1;
    }

    String getName() {
        return name;
    }

    int getPosition() {
        return position;
    }
}