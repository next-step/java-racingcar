package racingcar;

public class RacingCar {
    InputView inputView;
    private static int BOUND = 9;
    private static String MESSAGE_ERROR = "0보다 크고 9보다 작아야합니다.";
    private int point;

    public RacingCar (int point) {
        this.point = point;
    }

    public void move (int randomNumber) {
        if (randomNumber >= 9 || randomNumber <= 0) {
            throw new IllegalArgumentException(MESSAGE_ERROR);
        }
        if (randomNumber >= 4) {
            point++;
        }

    }

    public int getPoint () {
        return point;
    }
}