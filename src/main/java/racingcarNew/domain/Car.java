package racingcarNew.domain;

public class Car {

    private static final int CAR_MOVABLE_LIMIT_NUMBER = 4;
    private int position;
    private String name;

    public Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public String getCarName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }

    public int move(int randomNo) {
        if (randomNo >= CAR_MOVABLE_LIMIT_NUMBER) {
            position++;
        }
        return position;
    }

    public boolean isWinner(int winnerMoveCount) {
        return this.position == winnerMoveCount;
    }
}
