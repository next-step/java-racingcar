package step5.view;


import step5.domain.CarRacingGame;
import step5.domain.GameRound;
import step5.domain.dto.ResultOfCar;

import java.util.List;

public class OutputView {
    public static void printResult(CarRacingGame carRacingGame) {
        System.out.println("실행 결과");
        printCarsPosition(carRacingGame);
        printWinner(carRacingGame);
    }

    private static void printCarsPosition(CarRacingGame carRacingGame) {
        List<GameRound> gameResult = carRacingGame.getGameResult();
        for (GameRound gameRound : gameResult) {
            printOneRoundCarsPositions(gameRound);
        }
    }

    private static void printOneRoundCarsPositions(GameRound gameRound) {
        List<ResultOfCar> result = gameRound.getGameRoundResult();
        for (ResultOfCar resultOfCar : result) {
            printCarPosition(resultOfCar);
        }
        System.out.println();
    }

    private static void printCarPosition(ResultOfCar resultOfCar) {
        System.out.print(resultOfCar.getCarName() + " ");
        for (int i = 0; i < resultOfCar.getPosition(); i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    private static void printWinner(CarRacingGame carRacingGame) {
        List<String> winningNames = carRacingGame.getWinner();
        for (String winningName : winningNames) {
            System.out.print(winningName + " ");
        }
        System.out.println("(이)가 최종 우승했습니다.");
    }

}
