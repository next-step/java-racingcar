package study.racing.view;

import study.racing.domain.Car;
import study.racing.domain.RacingRecord;

import java.util.Set;
import java.util.stream.Collectors;

public class ResultView {

    public static void printResult(RacingRecord racingRecord) {
        Set<Car> cars = racingRecord.getRecords().keySet();

        for (int i = 1; i <= racingRecord.getTotalRound(); i++) {
            int round = i;
            cars.forEach(car -> {
                int distance = racingRecord.getRecords().get(car).get(round);
                View.outputView.printRepeatChar(car.getName() + " : ", '-', distance);
            });

            View.outputView.printRepeatChar();
        }
    }

    public static void printWinner(RacingRecord racingRecord) {
        String winners = racingRecord.findWinners().stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));

        View.outputView.println(winners + "가 최종 우승했습니다.");
    }
}
