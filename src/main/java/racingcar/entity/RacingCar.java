package racingcar.entity;


import racingcar.strategy.MoveStrategy;

public class RacingCar {
    public static final int BASE_POSITION = 0;
    public static final int ONE_STEP = 1;

    private String name;
    private int position;

    public RacingCar(String carName) {
        this.position = BASE_POSITION;
        if(carName.length() > 5){
            throw new IllegalArgumentException("이름은 5자를 초과할 수 없습니다.");
        }
        this.name = carName;
    }

    public void moveIfMovable(MoveStrategy moveStrategy) {
        if (moveStrategy.isMovable())
            position += ONE_STEP;
    }

    public int ifBiggerThanReturnPosition(int maxPosition){
        if (this.position > maxPosition) {
            return this.position;
        }
        return maxPosition;
    }
    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public boolean isSamePositionAs(int winnerRecord) {
        return position == winnerRecord;
    }
}
