package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.Round;

import java.util.List;

public class ResultView {

    private static final String RESULT_MESSAGE = "실행결과";
    private static final String CAR_POSITION_MODEL = "-";
    private static final String WINNER_MESSAGE = "가 최종 우승했습니다.";

    public void printResultMessage() {
        System.out.println(RESULT_MESSAGE);
    }

    public void printRacingResults(final List<Round> rounds) {
        for (Round round : rounds) {
            printRoundResults(round);
            System.out.println();
        }
    }

    public void printWinner(final String winners) {
        System.out.println(winners + WINNER_MESSAGE);
    }

    private void printRoundResults(Round round) {
        round.getRoundCarStatus().getCars().forEach(car -> {
            printCurrentCarPosition(car);
        });
    }

    private void printCurrentCarPosition(final Car car) {
        System.out.println(buildRoundResult(car));
    }

    private String buildCarPosition(final int carPosition) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < carPosition; i++) {
            stringBuilder.append(CAR_POSITION_MODEL);
        }
        return stringBuilder.toString();
    }

    private String buildRoundResult(final Car car) {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append(car.getCarName()).append(" : ").append(buildCarPosition(
            car.getCarPosition())).toString();
    }

}
