package step3_racing_car;

public class RacingGame {
    public static void main(String[] args) {
        new RacingGame().playGame();
    }
    void playGame() {
        // 게임 세팅
        int participantCarCount = InputOutputView.scanScarCount();
        int roundCount = InputOutputView.scanRoundCount();

        // 게임 룰 세팅 후 라운드 진행 - Random 전략으로 이동한다.
        RacingCars racingCars = new RacingCars(participantCarCount);
        GameRound gameRound = new GameRound(racingCars);
        gameRound.progressAllRound(roundCount, new RandomStrategy());

        // 게임 결과 확인
        InputOutputView.printGameResult(participantCarCount, racingCars);
    }
}
