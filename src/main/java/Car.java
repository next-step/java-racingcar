import java.util.Random;

public class Car implements Comparable<Car> {

    private final String name;
    private final int MAX_BOUND = 10;
    private final Position position;

    public Car(String name) {
        this(name, new Position(0));
    }

    public Car(String name, Position position) throws IllegalArgumentException {
        String trimmedName = name.trim();
        lengthCheck(trimmedName);
        this.name = trimmedName;
        this.position = position;
    }

    private static void lengthCheck(String trimmedName) {
        if (trimmedName.length() > 5) {
            throw new IllegalArgumentException("자동차의 이름은 5글자를 넘을 수 없습니다.");
        }
        if (trimmedName.isEmpty()) {
            throw new IllegalArgumentException("자동차의 이름은 최소 1글자 이상이어야 합니다");
        }
    }

    @Override
    public int compareTo(Car o) {
        return position.compareTo(o.position);
    }

    public void move(int number) {
        if (number >= 4) {
            position.add();
        }
    }

    public int getRandomNumber() {
        Random random = new Random();
        return random.nextInt(MAX_BOUND);
    }
}
