package racingcar.views;

import racingcar.domains.*;

import java.util.List;

public class ResultView {

    public static final String STR_RESULT_TITLE = "실행 결과";
    public static final String STR_DASH = "-";

    private ResultView() {}

    public static void showRaceResult(RacingResultsAll racingResultsAll, RacingCars racingCars) {
        System.out.println();
        System.out.println(STR_RESULT_TITLE);

        for (int i = 0; i < racingResultsAll.size(); i++) {
            drawRacingResultPerRound(racingResultsAll.getRacingResultsPerRound(i));
        }

        showRaceWinner(racingCars);
    }

    private static void drawRacingResultPerRound(RacingResultsPerRound racingResultsPerRound) {
        for (int j = 0; j < racingResultsPerRound.size(); j++) {
            drawRacingResultForEachCar(racingResultsPerRound.getRacingResultForEachCar(j));
        }

        System.out.println();
    }

    private static void drawRacingResultForEachCar(RacingResultForEachCar racingResultForEachCar) {
        StringBuilder carPath = new StringBuilder();

        for (int p = 0; p < racingResultForEachCar.getCarPosition(); p++) {
            carPath.append(STR_DASH);
        }

        System.out.println(racingResultForEachCar.getCarName()+" : "+carPath.toString());
    }

    private static void showRaceWinner(RacingCars racingCars) {
        List<String> winners = racingCars.getWinnerNames();
        StringBuilder strWinners = new StringBuilder();

        for (int i = 0; i < winners.size(); i++) {
            strWinners.append(winners.get(i)+" ");
        }

        System.out.println(strWinners.toString() + "가 최종 우승했습니다.");
    }

}
