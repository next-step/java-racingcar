package step03.car;

/**
 * Project : java-racingcar
 *
 * @author : jwdeveloper
 * @comment : Car의 책임 : 차는 움직인다.
 * Time : 9:23 오후
 */
public class Car {

    private int moveCount = 0;
    private final String carName;
    private static final int moveStandard = 4;

    public Car(String carName) {
        this.carName = carName;
    }

    public void AdvanceOneSpace(int moveCount) {

        if (moveCount >= moveStandard) {
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
