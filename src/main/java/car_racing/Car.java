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

    public boolean isWinner(Position maxPosition){
        return position.equals(maxPosition);
    }

    public Position getMaxPosition(Position maxPosition){
        if(position.lessThan(maxPosition)){
            return maxPosition;
        }
        return this.position;
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
