package racinggame.view;

import racinggame.domain.Car;
import racinggame.domain.Cars;
import racinggame.domain.Position;

import java.util.List;

public final class ResultView {
    private static final String SEPARATOR = " : ";
    private static final String MOVE_PATTERN = "-";
    private static final String COMMA = ",";

    public static void printWinners(Cars winners) {
        StringBuilder sb = new StringBuilder();

        List<Car> winnerList = winners.getCars();
        int winnerCnt = winnerList.size();

        for (int idx = 0; idx < winnerCnt; idx++) {
            sb.append(winnerList.get(idx).getCarName());
            if (idx < winnerCnt - 1) {
                sb.append(COMMA);
            }
        }
        sb.append("가 최종 우승했습니다.");
        System.out.println(sb.toString());
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
        StringBuilder sb = new StringBuilder();
        sb.append(car.getCarName());
        sb.append(SEPARATOR);
        sb.append(positionStatus(car.getPosition()));
        return sb.toString();
    }

    private static String positionStatus(Position position) {
        StringBuilder sb = new StringBuilder();
        sb.append(MOVE_PATTERN.repeat(position.getPosition()));
        return sb.toString();
    }
}
