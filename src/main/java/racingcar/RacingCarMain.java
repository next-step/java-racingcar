package racingcar;


import static racingcar.racing.Racing.racingStart;
import static racingcar.view.InputView.getSystemIn;

public class RacingCarMain {
    public static void main(String[] args) {
        int carCount = getSystemIn("자동차 대수는 몇 대 인가요?");
        int tryCount = getSystemIn("시도할 회수는 몇 회 인가요?");

        racingStart(carCount, tryCount);
    }
}
