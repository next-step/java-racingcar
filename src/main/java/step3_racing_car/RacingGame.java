package step3_racing_car;

import java.util.List;

public class RacingGame {
    public static void main(String[] args) {
        new RacingGame().playGame();
    }
    void playGame() {
        // 게임 세팅
        List<String> participantCarNames = InputOutputView.scanCarNames();
        int roundCount = InputOutputView.scanRoundCount();

        // 게임 룰 세팅 후 라운드 진행 - Random 전략으로 이동한다.
        RacingCars racingCars = new RacingCars(participantCarNames);
        GameRound gameRound = new GameRound(racingCars);
        gameRound.progressAllRound(roundCount, new RandomStrategy());

        // 우승자 선정
        InputOutputView.printGameWinner(prizeWinners(racingCars));
    }

    private RacingCars prizeWinners(RacingCars racingCars){
        return racingCars.getWinners();
    }
}
