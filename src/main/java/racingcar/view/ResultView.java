package racingcar.view;

import racingcar.domain.RacingResult;
import racingcar.domain.RacingResults;

import java.util.List;

public class ResultView {

    private static final char HYPHEN = '-';

    public static void showRacing(List<RacingResults> result) {
        for (int i = 0; i < result.size(); i++) {
            RacingResults racingResults = result.get(i);
            showRacingCarView(racingResults.getRacingResults());
            System.out.println();
        }
    }

    public static void showRacingCarView(List<RacingResult> racingCars) {
        for (int i = 0; i < racingCars.size(); i++) {
            showMoveCar(racingCars.get(i));
        }
    }

    public static void showMoveCar(RacingResult racingResult) {
        System.out.print(racingResult.getName() + " : ");
        for (int i = 0; i < racingResult.getPosition(); i++) {
            System.out.print(HYPHEN);
        }
        System.out.println();
    }

    public static void showWinner(List<String> names){
        String winners = String.join(", ", names);
        System.out.println(winners + " 가 최종 우승했습니다.");
    }

}
