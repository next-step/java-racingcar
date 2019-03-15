package racingcar.view.util;

import org.apache.commons.lang3.StringUtils;
import racingcar.domain.car.Car;

import java.util.List;

public class ResultView {

    public static void result(List<Car> cars, int turn) {
        for (int i = 1; i <= turn; i++) {
            printPosition(cars, i);
        }
    }

    private static void printPosition(List<Car> cars, int turn) {

        for (Car car : cars) {
            String result = car.getName() + " : ";
            result += printProgress(car, turn);
            System.out.println(result);
        }
        System.out.println();
    }

    private static String printProgress(Car car, int turn) {

        String progress = StringUtils.repeat("-", turn);

        if (car.getPosition() - turn < 0) {
            progress = StringUtils.repeat("-", car.getPosition());
        }

        return progress;
    }

    public static String winner(List<Car> winners) {
        StringBuilder stringBuilder = new StringBuilder();

        int count = winners.size();
        int i = 0;

        for (i = 0; i < count - 1; i++) {
            stringBuilder.append(winners.get(i).getName() + ", ");
        }
        stringBuilder.append(winners.get(count - 1).getName() + "가 최종 우승했습니다.");

        return stringBuilder.toString();
    }
}
