package car_racing;

import util.NumberGenerator;

public class Car {

    private final Name name;
    private Position position;

    private final NumberGenerator numberGenerator;

    public Car(final String name, NumberGenerator numberGenerator) {
        this(new Name(name), new Position(0), numberGenerator);
    }

    public Car(Name name, Position position, NumberGenerator numberGenerator) {
        this.name = name;
        this.position = position;
        this.numberGenerator = numberGenerator;
    }

    public Name getName() {
        return name;
    }

    public Position getPosition() {
        return position;
    }

    void moveOrStop() {
        int randomInt = numberGenerator.getRandomNumber();
        RandomNo randomNo = new RandomNo(randomInt);
        if (randomNo.canMove()) {
            position = position.move();
        }
    }


}
