package racingcar.view;

import racingcar.domain.RacingResult;

import java.util.List;

public class ResultView {
    private static final char HYPHEN = '-';

    public static void showRacing(List<RacingResult> result) {
        for (int i = 0; i < result.size(); i++) {
            RacingResult racingResult = result.get(i);
            showRacingCarView(racingResult.getPositions());
            System.out.println();
        }
    }

    public static void showRacingCarView(List<Integer> racingCars) {
        for (int i = 0; i < racingCars.size(); i++) {
            showMoveCar(racingCars.get(i));
        }
    }

    public static void showMoveCar(int position) {
        for (int i = 0; i < position; i++) {
            System.out.print(HYPHEN);
        }
        System.out.println();
    }
}
