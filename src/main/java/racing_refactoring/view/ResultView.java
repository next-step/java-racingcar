package racing_refactoring.view;

import racing_refactoring.domain.RacingCar;
import racing_refactoring.domain.RacingCars;
import racing_refactoring.domain.RacingWinners;

import java.util.List;

public class ResultView {
    private static final String MOVE_POINT = "-";
    private static final int FIRST_WINNER = 0;

    private ResultView() {
        throw new AssertionError();
    }

    public static void printStartLine() {
        System.out.println("실행 결과");
    }

    public static void renderProcess(RacingCars cars) {
        for (RacingCar car : cars.getRacingCars()) {
            renderProcess(car);
        }
        System.out.println(" ");
    }

    private static void renderProcess(RacingCar car) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(car.getName()).append(" ").append(":").append(" ");
        for (int i = 0; i < car.getPosition(); i++) {
            stringBuilder.append(MOVE_POINT);
        }
        System.out.println(stringBuilder);
    }

    public static void renderResult(RacingWinners winners) {
        StringBuilder stringBuilder = new StringBuilder();
        List<RacingCar> winnerList = winners.getWinners();
        for (int i = 0; i < winnerList.size(); i++) {
            writeWinnerList(winnerList.get(i), stringBuilder, i);
        }
        stringBuilder.append("가 최종 우승했습니다.");
        System.out.println(stringBuilder);
    }

    private static void writeWinnerList(RacingCar car, StringBuilder stringBuilder, int winnerOrder) {
        if (FIRST_WINNER == winnerOrder) {
            stringBuilder.append(car.getName());
            return;
        }
        stringBuilder.append(", ").append(car.getName());
    }
}
