package racingcar.view;

import racingcar.Constant;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.module.RacingRound;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class ResultView {

    public static void printResultView(RacingRound resultRound) {
        int tryNum = resultRound.getRoundResult().size();

        for (int num = 0; num < tryNum; num++) {
            resultRound.getRoundResult().get(num).stream()
                    .map(ResultView::convertIntToString).forEach(System.out::println);
            System.out.println();
        }

        printWinner(resultRound.getRoundResult().get(tryNum - 1));
    }

    private static String convertIntToString(Car car) {
        StringBuffer str = new StringBuffer();

        str.append(car.getName() + ":");
        for (int num = Constant.INPUT_ZERO_NUM; num < car.getPosition(); num++) {
            str.append("-");
        }
        return str.toString();
    }

    private static void printWinner(List<Car> cars) {

        int max = cars.stream().mapToInt(Car::getPosition).max().getAsInt();

        String winner = cars.stream().filter(car -> car.getPosition() == max)
                .map(Car::getName)
                .collect(Collectors.joining(", "));

        System.out.println(winner + "가 최종우승했습니다.");
    }
}
