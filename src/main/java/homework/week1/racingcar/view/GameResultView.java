package homework.week1.racingcar.view;

import homework.week1.racingcar.domain.GameResult;

import java.util.List;

public class GameResultView {
    private static final String WINNER_CAR_NAME_GUIDE = "가 최종 우승했습니다.";
    private static final String RUN_SYMBOL = "-";

    private GameResultView() {}

    public static GameResultView newInstance() {
        return new GameResultView();
    }

    public void printNumberOfRacingResults(List<GameResult> gameResults) {
        gameResults.stream()
                .forEach(t -> printRaceResultCars(t));
    }

    public void printRaceResultCars(GameResult gameResult) {
        gameResult.getResultCars().stream()
                .forEach(t -> printCar(t.getName(), t.getPosition()));
        printEmptyLine();
    }

    public void printCar(String carName, int position) {
        String positionSymbol = "";
        for (int index = 0 ; index < position; index++) {
            positionSymbol += RUN_SYMBOL;
        }
        System.out.println(carName + " : " + positionSymbol);
    }

    public void printWinnerCars(List<String> carNames) {
        System.out.println(String.join(", ", carNames) + WINNER_CAR_NAME_GUIDE);
    }

    public void printEmptyLine() {
        System.out.println();
    }
}
