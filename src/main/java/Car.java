public class Car implements Comparable<Car> {

    private final String name;
    private final Position position;

    public Car(String name) {
        this(name, new Position(0));
    }

    public Car(String name, Position position) throws IllegalArgumentException {
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차의 이름은 5글자를 넘을 수 없습니다.");
        }
        this.name = name;
        this.position = position;
    }

    @Override
    public int compareTo(Car o) {
        return position.compareTo(o.position);
    }
}
