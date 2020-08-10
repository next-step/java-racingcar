package step03.car;

/**
 * Project : java-racingcar
 *
 * @author : jwdeveloper
 * @comment : Car의 책임 : 차는 움직인다.
 * Time : 9:23 오후
 */
public class Car {
    private static final int MOVESTANDARD = 4;
    private int moveCount = 0;
    private final String carName;

    public Car(final String carName) {
        this.carName = carName;
    }

    public void advanceOneSpace(final int moveCount) {
        if (moveCount >= MOVESTANDARD) {
            this.moveCount += 1;
        }
    }

    public String getCarName() {
        return carName;
    }

    public int getMoveCount() {
        return moveCount;
    }

}
