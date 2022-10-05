package racingcar;

public class Car {
    private int position;

    private final String name;

    private final NumberGenerator numberGenerator;

    public Car(String name) {
        this(new RandomGenerator(), name);
    }

    public Car(NumberGenerator generator, String name) {
        this.position = 0;
        this.numberGenerator = generator;
        this.name = vaildCheckName(name);
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

    public int tryMove() {
        if (MovingCondtion.isMove(numberGenerator.makeValue())) {
            move();
        }
        return position;
    }

    public String vaildCheckName(String name) {
        if (name.length() > 5) {
            throw new RuntimeException(String.format("자동차 이름은 5자를 초과할 수 없다. - input name : [%s]", name));
        }
        return name;
    }
}
