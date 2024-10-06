package study.racing;

public class Car {
    private int carNo;
    private int moveCount;

    public Car() {
    }

    public Car(int carNo, int moveCount) {
        this.carNo = carNo;
        this.moveCount = moveCount;
    }

    public int getCarNo() {
        return carNo;
    }

    public void setCarNo(int carNo) {
        this.carNo = carNo;
    }

    public int getMoveCount() {
        return moveCount;
    }

    public void setMoveCount(int moveCount) {
        this.moveCount = moveCount;
    }
}
