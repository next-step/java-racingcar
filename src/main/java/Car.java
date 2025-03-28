public class Car implements Comparable<Car> {

    private final String name;
    private final Position position;

    public Car(String name) {
        this(name, new Position(0));
    }

    public Car(String name, Position position) throws IllegalArgumentException {
        String trimmedName = name.trim();
        if (trimmedName.length() > 5) {
            throw new IllegalArgumentException("자동차의 이름은 5글자를 넘을 수 없습니다.");
        }
        this.name = trimmedName;
        this.position = position;
    }

    @Override
    public int compareTo(Car o) {
        return position.compareTo(o.position);
    }

    public void move(boolean condition) {
        if (condition) {
            position.add();
        }
    }
}
