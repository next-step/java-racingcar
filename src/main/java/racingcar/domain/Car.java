package racingcar.domain;

public class Car {

    private int position;
    private String name;
    private final int CAR_MOVE_CRITERIA = 4;
    private final int CAR_NAME_LENGTH_LIMIT = 5;
    private final RandomGenerator randomGenerator;

    public Car() {
        this.position = 0;
        randomGenerator = new RandomGenerator();
    }

    public Car(String name) {
        this.name = vlidateName(name);
        this.position = 0;
        randomGenerator = new RandomGenerator();
    }

    private String vlidateName(String name) {
        if (name.length() > CAR_NAME_LENGTH_LIMIT) {
            throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.");
        }
        return name;
    }

    public boolean isOver(int randomValue) {
        return CAR_MOVE_CRITERIA <= randomValue;
    }

    public void move() {
        int randomValue = randomGenerator.getValue();
        if (isOver(randomValue)) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
}
