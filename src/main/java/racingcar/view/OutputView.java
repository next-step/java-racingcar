package racingcar.view;

import java.util.List;
import racingcar.controller.RacingGameController;
import racingcar.model.Car;
import racingcar.model.RaceResult;

public class OutputView {

    private static final String WINNER_MESSAGE = "최종 우승자: ";
    private static final String GAME_RESULT_MESSAGE = "출력결과";

    public void printResult(List<RaceResult> totalResult) {
        System.out.println(GAME_RESULT_MESSAGE);
        for (RaceResult raceResult : totalResult) {
            printEachRoundResult(raceResult.getRaceResultByRound());
        }
    }

    private void printEachRoundResult(List<Car> cars) {
        for (Car car : cars) {
            System.out.print(car.getCarName() + ": ");
            printPosition(car.getPosition());
        }
        System.out.println();
    }

    private void printPosition(int position) {
        for (int i = 0; i < position; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public void printWinner(List<String> winners) {
        System.out.print(WINNER_MESSAGE);
        System.out.print(String.join(",", winners));
    }


}
