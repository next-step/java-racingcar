package race.view;

import race.Car;
import race.CarName;
import race.CarView;

import java.util.List;

public class ResultView {
    private static final char POSITION_CHARACTER = '-';

    public static void showResultComment() {
        System.out.println("실행 결과");
    }

    public static void showCarViewList(List<CarView> carViewList) {
        for (CarView carView : carViewList) {
            showCarView(carView);
        }
        System.out.println();
    }

    private static void showCarView(CarView carView) {
        StringBuilder stringBuilder = new StringBuilder()
                .append(carView.getCarName())
                .append(" : ");
        System.out.print(stringBuilder);
        for (int i = 0; i < carView.getPosition(); i++) {
            System.out.print(POSITION_CHARACTER);
        }
        System.out.println();
    }

    public static void showWinners(List<CarView> winners) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < winners.size(); i++) {
            stringBuilder.append(getCommaIndexCondition(i));
            stringBuilder.append(winners.get(i).getCarName());
        }
        stringBuilder.append("가 최종 우승했습니다.");
        System.out.println(stringBuilder);
    }

    private static String getCommaIndexCondition(int i) {
        if (i > 0) {
            return ", ";
        }
        return "";
    }
}
