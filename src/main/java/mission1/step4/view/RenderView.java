package mission1.step4.view;

import mission1.step4.domain.car.Car;
import mission1.step4.domain.car.CarEntry;

import java.util.List;

public class RenderView {

    private static final String EXPRESSION = "-";

    public static void showCarProgress(CarEntry carEntry) {
        StringBuilder sb = new StringBuilder();

        for (Car car : carEntry) {
            sb.append(car.getName() + ": ");
            for (int i = 0; i < car.getProgress(); i++) {
                sb.append(EXPRESSION);
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }

    public static void showRaceWinner(List<Car> RaceWinnerList) {
        StringBuilder sb = new StringBuilder();

        for (Car car : RaceWinnerList) {
            sb.append(",");
            sb.append(car.getName());
        }

        sb.append("가 최종 우승했습니다.");
        System.out.println(sb.toString().replaceFirst(",", ""));
    }
}
