package race.view;

import race.CarResult;

import java.util.List;

public class ResultView {
    private static final char POSITION_CHARACTER = '-';

    public static void showResultComment() {
        System.out.println("실행 결과");
    }

    public static void showCarViewList(List<CarResult> carResultList) {
        for (CarResult carResult : carResultList) {
            showCarView(carResult);
        }
        System.out.println();
    }

    private static void showCarView(CarResult carResult) {
        StringBuilder stringBuilder = new StringBuilder()
                .append(carResult.getCarName())
                .append(" : ");
        System.out.print(stringBuilder);
        for (int i = 0; i < carResult.getPosition(); i++) {
            System.out.print(POSITION_CHARACTER);
        }
        System.out.println();
    }

    public static void showWinners(List<CarResult> winners) {
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
