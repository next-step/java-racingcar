package racing.view;

import racing.domain.Car;
import racing.domain.RacingGame;

import java.util.List;

public class ResultView {
    private static final String PROGRESS_MARK = "-";

    private ResultView() {
    }

    public static void getProgress(RacingGame racingGame) {
        List<Car> racingCarList = racingGame.getRacingCars();
        racingCarList.forEach(o -> printProgress(o.getPosition()));
    }

    private static void printProgress(int position) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < position; i++) {
            sb.append(PROGRESS_MARK);
        }
        System.out.println(sb);
    }
}
