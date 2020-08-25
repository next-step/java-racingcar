package step03.car;

/**
 * Project : java-racingcar
 *
 * @author : jwdeveloper
 * @comment : Car의 책임 : 차는 움직인다.
 * Time : 9:23 오후
 */
public class Car implements Comparable<Car>{
    private static final int MOVESTANDARD = 4;
    private int moveCount = 0;
    private final String carName;

    public Car(final String carName, final int moveCount) {
        this.carName = carName;
        this.moveCount = moveCount;
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

    @Override
    public int compareTo(final Car o) {
        return this.moveCount <= o.moveCount ? 1 : -1;
    }

}
