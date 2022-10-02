package racing_car_with_winner;


import racing_car_with_winner.exception.InvalidInputException;

public class GameAttemptCount {
    private Integer value;

    public GameAttemptCount(Integer value) {
        if (value == null) {
            throw new InvalidInputException("시도할 회수가 유효하지 않습니다");
        }
        this.value = value;
    }
}
