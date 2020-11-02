package race.car;

/**
 * 자동차의 움직인 거리와 댓수를 관리하는 객체
 */
public class CarImformation {

    private int[] tryMoveCount; // 움직인 거리
    private int  carCount; // 자동채 댓수

    CarImformation(int[] tryMoveCount, int carCount) {
        this.tryMoveCount = tryMoveCount;
        this.carCount = carCount;
    }

    public int[] getTryMoveCount() {
        return tryMoveCount;
    }

    public int getCarCount() {
        return carCount;
    }
}
