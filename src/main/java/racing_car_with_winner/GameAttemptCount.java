package racing_car_with_winner;


import racing_car_with_winner.exception.InvalidInputException;

public class GameAttemptCount {
    private int value;

    public GameAttemptCount(int value) {
        if (value < 0) {
            throw new InvalidInputException("시도할 회수가 유효하지 않습니다");
        }

        this.value = value;
    }
}
