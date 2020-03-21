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

    public String getPositionView() {
        return position.getView();
    }
}
