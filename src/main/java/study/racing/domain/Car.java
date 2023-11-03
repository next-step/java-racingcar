package study.racing.domain;

public class Car {

    private static final int NEXT_POSITION = 1;
    private static final int STANDARD_NUMBER = 4;
    private Position position;

    public Car(Position position) {
        this.position = position;
    }

    public String move(int randomNumber) {

        if (randomNumber >= STANDARD_NUMBER) {
            this.position = new Position(position.getValue() + NEXT_POSITION);
        }
        return position.getDash();
    }
}
