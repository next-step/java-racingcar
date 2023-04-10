package racingcar;

public class RacingCar {
    private int position = 0;
    public void goOrStop(int input) {
        if (input < 0 || input > 9) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
        if (input >= 4) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }
}
