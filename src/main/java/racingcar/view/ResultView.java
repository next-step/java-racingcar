package racingcar.view;

import racingcar.domain.RacingResult;

import java.util.List;

public class ResultView {
    private static final char HYPHEN = '-';

    public void showRacing(List<RacingResult> results) {
        for (int i = 0; i < results.size(); i++) {
            RacingResult racingResult = results.get(i);
            showRacingCarView(racingResult.getPositions());
            System.out.println();
        }
    }

    public void showRacingCarView(List<Integer> cars) {
        for (int i = 0; i < cars.size(); i++) {
            showMoveCar(cars.get(i));
        }
    }

    public void showMoveCar(int position) {
        for (int i = 0; i < position; i++) {
            System.out.println(HYPHEN);
        }
        System.out.println();
    }
}
