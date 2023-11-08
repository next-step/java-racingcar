package racingcar;

public class CarMain {
    public static void main(String[] args) {
        // 입력
        InputView inputView = new InputView();
        int carCount = inputView.getInputNumber("자동차 대수는 몇 대 인가요?");
        int chance = inputView.getInputNumber("시도할 횟수는 몇 회 인가요?");

        // 경주
        RacingGame racingGame = new RacingGame(carCount, chance);
        racingGame.racing();
    }
}
