package racingGame;

public class Car {

    private Condition condition = new Condition();
    private int position;

    public void start(RandomNumber randomNumber) {
        condition.init(randomNumber);
        if (condition.isOk()) {
            move();
        }
    }

    public void move() {
        position++;
    }

    public int getPosition() {
        return position;
    }
}
