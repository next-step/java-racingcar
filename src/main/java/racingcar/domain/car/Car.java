package racingcar.domain.car;

import racingcar.domain.random.RandNum;
import racingcar.domain.random.RandomNumberGenerator;

public class Car {
    private final static int MOVE_CRITERIA = 4;

    private final RandomNumberGenerator randomGenerator;
    private final Name name;
    private Position position;

    public Car(String name,
               RandomNumberGenerator randomGenerator) {

        this(randomGenerator, new Name(name), new Position());
    }

    public Car(String name,
               int location,
               RandomNumberGenerator randomGenerator) {

        this(randomGenerator, new Name(name), new Position(location));
    }

    public Car(RandomNumberGenerator randomGenerator,
               Name name,
               Position position) {

        this.randomGenerator = randomGenerator;
        this.name = name;
        this.position = position;
    }

    public Position location() {
        return this.position;
    }

    public Name name() {
        return this.name;
    }

    public void move() {
        RandNum randomNumber = randomGenerator.generate();

        if (randomNumber.isGreaterThan(MOVE_CRITERIA)) {
            this.position = position.move();
        }
    }

    public boolean isWinner(Position maxLocation) {
        return this.position.isGreaterThan(maxLocation);
    }

    public Position maxLocation(Position criteria) {
        return this.position.max(criteria);
    }

    public boolean isAt(Position location) {
        return this.position.equals(location);
    }
}
