package racingGame.ui;

import racingGame.domain.GameResult;
import racingGame.domain.RoundResult;
import racingGame.domain.car.RacingCar;

import java.util.List;

public class RacingCarOutputView {
    public void printGame(GameResult gameResult) {
        printGameStart();
        for (RoundResult roundResult : gameResult.getRoundResults()) {
            printRoundResult(roundResult);
        }
        printWinners(gameResult.getWinners());
    }

    private void printGameStart() {
        System.out.println("실행 결과");
    }

    private void printRoundResult(RoundResult roundResult) {
        for (RacingCar car : roundResult.getRacingCars()) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        }
        System.out.println();
    }

    private void printWinners(List<String> winners) {
        System.out.println(String.join(", ", winners) + "가 최종 우승했습니다.");
    }


}