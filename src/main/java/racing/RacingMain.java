package racing;

public class RacingMain {

    private RacingMain() {
        throw new AssertionError();
    }

    public static void main(String[] args) {
        racingGame();
    }

    private static void racingGame() {
        int carCount = InputView.scan("자동차 대수는 몇 대 인가요?");
        int moveCount = InputView.scan("시도할 회수는 몇 회 인가요?");

        Racing.racing(carCount, moveCount);
    }
}