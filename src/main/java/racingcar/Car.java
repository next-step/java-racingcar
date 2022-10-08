package racingcar;

public class Car {

    private static final int NAME_LENGTH_LIMIT = 5;
    private int position;

    private final String name;

    private final NumberGenerator numberGenerator;

    public Car(String name) {
        this(new RandomGenerator(), name);
    }

    public Car(NumberGenerator generator, String name) {
        this.position = 0;
        this.numberGenerator = generator;
        this.name = validCheckName(name);
    }

    private void move() {
        this.position++;
    }

    public int getPosition() {
        return this.position;
    }

    public String getName() {
        return name;
    }

    public void tryMove() {
        if (MovingCondition.isMove(numberGenerator.makeValue())) {
            move();
        }
    }

    public String validCheckName(String name) {
        if (name.length() > NAME_LENGTH_LIMIT) {
            throw new RuntimeException(String.format("자동차 이름은 5자를 초과할 수 없다. - input name : [%s]", name));
        }
        return name;
    }
}
