package racingcar.view;

import java.util.stream.Collectors;
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

    private void printRoundResults(final Round round) {
        round.getRoundCarStatus().getCars().forEach(car -> {
            printCurrentCarPosition(car);
        });
    }

    private String buildRoundResult(final Car car) {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append(car.getCarName()).append(" : ").append(buildCarPosition(
            car.getCarPosition())).toString();
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

    public void printWinner(final List<Car> cars) {
        System.out.println(getWinnersCarName(cars) + WINNER_MESSAGE);
    }

    private String getWinnersCarName(final List<Car> cars) {
        return cars.stream().map(Car::getCarName).collect(Collectors.joining(","));
    }

}
