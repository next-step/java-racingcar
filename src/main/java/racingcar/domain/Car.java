package racingcar.domain;

public class Car implements Vehicle {
    private final int MOVABLE_NUMBER = 4;
    private final Name name;
    private Position position;

    public Car(String name) {
        this.name = new Name(name);
        this.position = new Position(0);
    }

    @Override
    public String getName() {
        return name.getName();
    }

    @Override
    public Integer getPosition() {
        return this.position.getPosition();
    }

    @Override
    public void move(int number) {
        if (isMovable(number)) {
            this.position.increase();
        }
    }

    @Override
    public Integer max(int other) {
        return this.position.max(other);
    }

    @Override
    public boolean isMatch(int position) {

        return this.position.isMatch(position);
    }


    private boolean isMovable(int number) {
        return number >= MOVABLE_NUMBER;
    }


}
