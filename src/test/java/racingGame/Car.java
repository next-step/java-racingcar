package racingGame;

public class Car {

    private Condition condition = new Condition();
    private Position position = new Position();

    public void start(RandomNumber randomNumber) {
        condition.init(randomNumber);
        if (condition.isOk()) {
            move();
        }
    }

    public void move() {
        position.add();
    }

    public int getPosition() {
        return position.getValue();
    }
}
