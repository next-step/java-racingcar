package racingGame;

public class Car {

    private int position = 0;

    public void move(MoveStrategy strategy) {
        if (strategy.isMove()) {
            position++;
        }
    }

    public int position() {
        return position; // getter지만 의미 있는 상태 노출
    }
}
