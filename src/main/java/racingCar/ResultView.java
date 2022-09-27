package racingCar;

import java.util.List;

public class ResultView {

    private static final String S_GAME_RESULT = "실행 결과";
    public static final String MSG_FINAL_WINNERS = "가 최종 우승했습니다.";

    public static void printGameResult() {
        System.out.println(S_GAME_RESULT);
    }

    public static void printPlayResult(Cars cars) {
        for (Car car : cars.getCars()) {
            printCarPosition(car);
        }
    }

    public static void printCarPosition(Car car) {
        System.out.print(car.getName() + " : ");
        for (int i = 0; i < car.getPos(); i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public static void printWinners(List<String> winners) {
        String sWinners = "";
        for (String winner : winners) {
            sWinners += winner + ", ";
        }
        System.out.println(sWinners.substring(0, sWinners.length() - 2) + MSG_FINAL_WINNERS);

    }
}
