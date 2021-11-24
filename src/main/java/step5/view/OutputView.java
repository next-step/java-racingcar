package step5.view;


import step5.domain.GameHistory;
import step5.domain.GameRound;
import step5.domain.dto.CarData;

import java.util.List;

public class OutputView {

    private static final String POSITION_MARK = "-";

    public static void printResult() {
        System.out.println("실행 결과");
    }

    public static void printHistory(GameHistory gameHistory){
        printCarsPosition(gameHistory);

    }

    private static void printCarsPosition(GameHistory gameHistory) {
        List<GameRound> gameRounds = gameHistory.totalResult();
        for (GameRound gameRound : gameRounds) {
            printOneRoundCarsPositions(gameRound);
        }
    }

    private static void printOneRoundCarsPositions(GameRound gameRound) {
        List<CarData> result = gameRound.getRoundResult();
        for (CarData carData : result) {
            printCarPosition(carData);
        }
        System.out.println();
    }

    private static void printCarPosition(CarData carData) {
        System.out.print(carData.getCarName() + " ");
        for (int i = 0; i < carData.getPosition(); i++) {
            System.out.print(POSITION_MARK);
        }
        System.out.println();
    }

    public static void printWinner(List<String> winners) {
        for (String winningName : winners) {
            System.out.print(winningName + " ");
        }
        System.out.println("(이)가 최종 우승했습니다.");
    }

}
