package racing.carRacing;

public class Car implements Comparable<Car> {
    public static final int MAX_SIZE_OF_NAME = 5;
    public static final int FIRST_POSITION = 0;

    private int position;
    private String name;

    public Car(int position, String name) {
        checkNameValidation(name);
        this.position = position;
        this.name = name;
    }

    public Car(String name) {
        this(FIRST_POSITION, name);
    }

    private void checkNameValidation(String name) {
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
        if (name.length() > MAX_SIZE_OF_NAME) {
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

    public boolean equalsPosition(int position) {
        return this.position == position;
    }

    @Override
    public int compareTo(Car car) {
        return position - car.getCurrentPosition();
    }
}
