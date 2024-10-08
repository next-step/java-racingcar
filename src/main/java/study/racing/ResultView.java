package study.racing;

import study.racing.domain.Car;
import study.racing.domain.RacingHistory;
import study.racing.domain.Winner;

import java.util.List;

public class ResultView {

    final static String FORWARD_DASH = "-";

    public static void printView(RacingHistory racingHistory) {
        StringBuilder stringBuilder = new StringBuilder();

        for(int i = 0; i < racingHistory.getSize(); i++) {
            appendCarsInfo(stringBuilder, racingHistory.getRacingHistory(i));
        }
        System.out.print(stringBuilder);
    }

    public static void printViewWinner(RacingHistory racingHistory, List<Winner> winners) {
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder stringBuilderWinner = new StringBuilder();

        for(int i = 0; i < racingHistory.getSize(); i++) {
            appendCarsInfo(stringBuilder, racingHistory.getRacingHistory(i));
        }
        System.out.print(stringBuilder);

        for(Winner winner : winners) {
            stringBuilderWinner.append(winner.getWinnerName());
        }

        stringBuilderWinner.append("가 최종 우승했습니다.");
        System.out.println(stringBuilderWinner);
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

}
