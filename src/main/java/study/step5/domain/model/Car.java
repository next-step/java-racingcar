package study.step5.domain.model;

public class Car implements Comparable<Car> {
    private static final int STARTING_CONDITION = 4;
    private Position position;
    private Name name;

    public Car(final String name) {
        this.name = new Name(name);
        this.position = new Position();
    }

    public void move(int randomInt) {
        moveCar(isMove(randomInt));
    }

    public Boolean isMove(int input) {
        return input >= STARTING_CONDITION;
    }

    private void moveCar(boolean moveResult) {
        if (moveResult) {
            position.increase();
        }
    }

    public int getPosition() {
        return position.getPosition();
    }

    public String getName() {
        return name.getName();
    }

    boolean isWinner(int winnerPosition) {
        return position.getPosition() == winnerPosition;
    }


    @Override
    public int compareTo(Car car) {
        return (this.position.getPosition() > car.position.getPosition()) ? 1 : -1;
    }
}
