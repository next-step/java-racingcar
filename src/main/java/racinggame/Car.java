package racinggame;

/**
 * 1. 자동차 번호 필드
 * 1. 움직이는 거리 필드
 * 1. 게임 진행시 자동차 이동
 */
public class Car {
    private int carNumber;
    private int moveRange = 0;

    public Car(int carNumber) {
        this.carNumber = carNumber;
    }

    /**
     * 랜던값이 4보다 크면 자동차 한칸 이동
     */
    public void moveCar() {
        if (NumberVo.isGreaterThan4((NumberVo.createRandomNumber()))) {
            this.moveRange++;
        }
    }

    public int getCarNumber() {
        return carNumber;
    }

    public int getMoveRange() {
        return moveRange;
    }
}
