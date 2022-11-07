package racinggame.view;

import racinggame.domain.Car;
import racinggame.domain.Cars;
import racinggame.domain.Position;

import java.util.List;

public final class ResultView {
    private static final String SEPARATOR = " : ";
    private static final String MOVE_PATTERN = "-";
    private static final String COMMA = ",";
    private static final StringBuilder stringBuilder = new StringBuilder();

    public static void printWinners(Cars winners) {
        stringBuilder.setLength(0);
        List<Car> winnerList = winners.getCars();
        int winnerCnt = winnerList.size();

        for (int idx = 0; idx < winnerCnt; idx++) {
            stringBuilder.append(winnerList.get(idx).getCarName());
            if (idx < winnerCnt - 1) {
                stringBuilder.append(COMMA);
            }
        }
        stringBuilder.append("가 최종 우승했습니다.");
        System.out.println(stringBuilder.toString());
    }

    public static void printRacingResult(Cars cars) {
        List<Car> carList = cars.getCars();
        printRacingResult(carList);
    }

    private static void printRacingResult(List<Car> carList) {
        for (Car car : carList) {
            System.out.println(printCarPosition(car));
        }
        System.out.println();
    }

    private static String printCarPosition(Car car) {
        stringBuilder.setLength(0);
        stringBuilder.append(car.getCarName());
        stringBuilder.append(SEPARATOR);
        stringBuilder.append(positionStatus(car.getPosition()));
        return stringBuilder.toString();
    }

    private static String positionStatus(Position position) {
        stringBuilder.setLength(0);
        stringBuilder.append(MOVE_PATTERN.repeat(position.getPosition()));
        return stringBuilder.toString();
    }
}
