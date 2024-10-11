package study.racing;

import study.racing.domain.Car;
import study.racing.domain.RacingHistory;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

    final static String FORWARD_DASH = "-";

    public static void printView(RacingHistory racingHistory) {
        StringBuilder stringBuilder = new StringBuilder();

        for(int i = 0; i < racingHistory.getSize(); i++) {
            appendCarsInfo(stringBuilder, racingHistory.getRacingHistory(i));
        }
        System.out.print(stringBuilder);
    }

    public static void printRacingHistory(RacingHistory racingHistory) {
        StringBuilder stringBuilder = new StringBuilder();

        for(int i = 0; i < racingHistory.getSize(); i++) {
            appendCarsInfo(stringBuilder, racingHistory.getRacingHistory(i));
        }
        System.out.print(stringBuilder);
    }

    private static void appendCarsInfo(StringBuilder stringBuilder, List<Car> cars) {
        for(Car car : cars) {
            String carName = car.getCarName() != null ? car.getCarName() : String.valueOf(car.getCarNo());
            stringBuilder.append(carName).append(" : ");
            appendCarInfo(stringBuilder, car);
        }
        stringBuilder.append("\n");
    }

    private static void appendCarInfo(StringBuilder stringBuilder, Car car) {
        for (int i = 0; i < car.getMoveCount(); i++) {
            stringBuilder.append(FORWARD_DASH);
        }
        stringBuilder.append("\n");
    }

    public static void printWinner(List<Car> winners) {
        String winnerNames = winners.stream()
                .map(Car::getCarName)
                .collect(Collectors.joining(", "));
        System.out.println(winnerNames + "가 최종 우승했습니다.");
    }

}
