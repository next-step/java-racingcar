package racing.view;

import racing.domain.Car;
import racing.domain.RacingGame;

import java.util.List;

public class ResultView {
    private static final String PROGRESS_MARK = "-";
    private static final String USER_NAME_POSTFIX = " : ";

    private static final String WINNER_NOTICE = "가 최종 우승했습니다.";

    private ResultView() {
    }

    public static void printProgressView(RacingGame racingGame) {
        List<Car> racingCarList = racingGame.getRacingCars();
        racingCarList.forEach(o -> printProgress(o.getUserName(), o.getPosition()));
    }

    public static void printWinnerNoticeView(RacingGame racingGame) {
        System.out.println(racingGame.getWinnersName() + WINNER_NOTICE);
    }

    private static void printProgress(String userName, int position) {
        StringBuilder sb = new StringBuilder();

        sb.append(userName).append(USER_NAME_POSTFIX);
        for (int i = 0; i < position; i++) {
            sb.append(PROGRESS_MARK);
        }
        System.out.println(sb);
    }
}
