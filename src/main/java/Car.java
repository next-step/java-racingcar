import java.util.Random;

/**
 * 이름, 위치를 가지는 자동차 클래스
 * 비교 가능해야 하므로 Comparable 인터페이스를 구현함
 */
public class Car implements Comparable<Car> {

    public final String name;
    public final Position position;

    public Car(String name) {
        this(name, new Position(0));
    }

    public Car(String name, Position position) throws IllegalArgumentException {
        String trimmedName = name.trim();
        lengthCheck(trimmedName);
        this.name = trimmedName;
        this.position = position;
    }

    /**
     * 이름에 대한 Validation
     */
    private static void lengthCheck(String trimmedName) {
        if (trimmedName.length() > 5) {
            throw new IllegalArgumentException("자동차의 이름은 5글자를 넘을 수 없습니다.");
        }
        if (trimmedName.isEmpty()) {
            throw new IllegalArgumentException("자동차의 이름은 최소 1글자 이상이어야 합니다");
        }
    }

    /**
     * 실제 차량이 움직이는 메서드
     */
    public void move(int number) {
        if (number >= 4) {
            position.add();
        }
    }

    @Override
    public int compareTo(Car o) {
        return position.compareTo(o.position);
    }
}
