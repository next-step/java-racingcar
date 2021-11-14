package racingcar.view;

import racingcar.domain.model.Car;
import racingcar.domain.game.GameResult;
import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
    public void printResult(boolean printWinners, GameResult result) {
        printRoundResults(result.getRoundResults());
        if(printWinners) printWinners(result.getWinners());
    }

    private void printRoundResults(List<String> roundResults) {
        roundResults.forEach(result -> System.out.println(result));
    }

    private void printWinners(List<Car> winners){
        String winnerCarNames = winners.stream()
                .map(car -> car.getName())
                .collect(Collectors.joining(","));
        System.out.println(winnerCarNames + "가 최종 우승했습니다.");
    }
}