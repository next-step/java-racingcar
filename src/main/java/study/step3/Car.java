package study.step3;

public class Car {
    private static final int STANDARD_VALUE_TO_MOVE = 3;

    private Name name;
    private Position position;

    public Car(String name) {
        this.name = new Name(name);
        position = new Position(0);
    }

    public Car(String name, int position) {
        this.name = new Name(name);
        this.position = new Position(position);
    }

    Position getPosition() {
        return position;
    }

    Name getName() {
        return name;
    }

    boolean isThisName(String name) {
        return this.name.equals(new Name(name));
    }

    Position move(int randomNum) {
        if (isExceedStandard(randomNum)) {
            position.increase();
        }
        return position;
    }

    boolean isBiggerPosition(Position position) {
        return this.position.isBigger(position);
    }


    boolean isExceedStandard(int num) {
        return num > STANDARD_VALUE_TO_MOVE;
    }

    boolean isCarPosition(int position) {
        return this.position.equals(new Position(position));
    }

    boolean isCarPosition(Position position) {
        return this.position.equals(position);
    }
}
