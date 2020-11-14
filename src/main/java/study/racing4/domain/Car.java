package study.racing4.domain;

public class Car {

    private static final int MAX_LENGTH = 5;
    private final String name;
    private int position;

    public Car(String name) {
        validateName(name);
        this.name = name;
        this.position = 0;
    }

    public Car(String name, int position) {
        validateName(name);
        validatePosition(position);
        this.name = name;
        this.position = position;
    }

    private void validateName(String name) {
        if(name.length() > MAX_LENGTH ) {
            throw new IllegalArgumentException("자동차의 이름은 5자를 넘지 않아야 합니다.");
        }
    }

    private void validatePosition(int position) {
        if(position < 0 ) {
            throw new IllegalArgumentException("자동차의 위치는 음수 일 수 없습니다.");
        }
    }

    public String getName() {
        return name;
    }

    public void move() {
        this.position++;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        if (position != car.position) return false;
        return name != null ? name.equals(car.name) : car.name == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + position;
        return result;
    }
}
