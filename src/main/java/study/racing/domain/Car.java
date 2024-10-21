package study.racing.domain;

public class Car {
    private int carNo;
    private int moveCount;
    private String carName;


    private Car(Builder builder) {
        this.carNo = builder.carNo;
        this.moveCount = builder.moveCount;
        this.carName = builder.carName;
    }

    public static class Builder {
        private int carNo;
        private int moveCount;
        private String carName;

        public Builder setCarNo(int carNo) {
            this.carNo = carNo;
            return this;
        }

        public Builder setMoveCount(int moveCount) {
            this.moveCount = moveCount;
            return this;
        }

        public Builder setCarName(String carName) {
            this.carName = carName;
            return this;
        }

        public Car build() {
            return new Car(this);
        }
    }

    public int getCarNo() {
        return carNo;
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

    public void move(int count) {
        this.moveCount += count;
    }

    @Override
    public String toString() {
        return "Car " + (carName != null ? carName : carNo) + " (Moves: " + moveCount + ")";
    }
}
