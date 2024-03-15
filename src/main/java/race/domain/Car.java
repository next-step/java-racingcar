package race.domain;

public class Car implements Comparable<Car> {

    private final int CONDITION_OF_MOVE = 4;
    private final static int MAX_LENGTH_OF_NAME = 5;
    private int position;
    private final String name;

    private Car(String name) {
        validateName(name);
        this.name = name;
    }

    public static Car createInstance(String name) {
        return new Car(name);
    }

    public void move(int number) {
        if (!canMove(number)) {
            return;
        }
        position++;
    }

    private boolean canMove(int number) {
        return number >= CONDITION_OF_MOVE;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public Boolean isSamePosition(Car car) {
        return position == car.getPosition();
    }

    private void validateName(String name) {
        int lengthOfName = name.length();
        if (lengthOfName > MAX_LENGTH_OF_NAME) {
            throw new IllegalArgumentException(
                    String.format("이름을 5자를 초과 할수 없습니다. 해당 이름은 %s 는 %d ", name, lengthOfName));
        }
    }

    @Override
    public int compareTo(Car o) {
        return Integer.compare(position, o.getPosition());
    }
}
