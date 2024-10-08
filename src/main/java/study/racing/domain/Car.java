package study.racing.domain;

public class Car {
    private int carNo;
    private int moveCount;
    private String carName;

    public Car(int carNo, int moveCount) {
        this.carNo = carNo;
        this.moveCount = moveCount;
    }

    public Car(String carName, int moveCount) {
        this.carName = carName;
        this.moveCount = moveCount;
    }

    public Car(int carNo, int moveCount, String carName) {
        this.carNo = carNo;
        this.moveCount = moveCount;
        this.carName = carName;
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

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    @Override
    public String toString() {
        return "Car " + carNo + " (Moves: " + moveCount + ")";
    }
}
