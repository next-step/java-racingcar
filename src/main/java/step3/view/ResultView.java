package step3.view;

import step3.domain.CarRacingResult;
import step3.util.StringUtil;

import java.util.stream.Collectors;

public class ResultView {

    private final String DISTANCE_EXPRESSION = "-";
    private final String WINNER_DELIMITER = ", ";

    private CarRacingResult carRacingResult;

    public ResultView(CarRacingResult carRacingResult) {
        System.out.println("실행 결과");
        this.carRacingResult = carRacingResult;
    }

    public void printOutRacingResult() {
        carRacingResult.getCarRoundResults()
                .forEach(carRoundResult -> {
                    carRoundResult.getCarPositionList()
                            .forEach(carPosition -> printCar(carPosition.getCarName(), carPosition.getPosition()));
                    System.out.println();
                });
    }

    private void printCar(String carName, int position) {
        System.out.println(carName + ":" + StringUtil.repeat(DISTANCE_EXPRESSION, position));
    }

    public void printOutWinnerCarName() {
        String winnerCarName = carRacingResult.getWinner().findWinnerCarNames()
                .stream()
                .collect(Collectors.joining(WINNER_DELIMITER));
        System.out.println(String.format("%s(이)가 최종 우승했습니다.", winnerCarName));
    }
}
