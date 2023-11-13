package racing.view;

import racing.domain.Car;
import racing.domain.RacingGame;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
    private static final String PROGRESS_MARK = "-";
    private static final String USER_NAME_POSTFIX = " : ";

    private static final String WINNER_NOTICE = "가 최종 우승했습니다.";

    private ResultView() {
    }

    public static void printProgressView(RacingGame racingGame) {
        List<Car> racingCars = racingGame.getRacingCars();
        racingCars.forEach(o -> printProgress(o.getCarName(), o.getPosition().getValue()));
    }

    public static void printWinnerNoticeView(RacingGame racingGame) {
        System.out.println(getWinnersName(racingGame) + WINNER_NOTICE);
    }

    private static void printProgress(String userName, int position) {
        StringBuilder sb = new StringBuilder();

        sb.append(userName).append(USER_NAME_POSTFIX);
        for (int i = 0; i < position; i++) {
            sb.append(PROGRESS_MARK);
        }
        System.out.println(sb);
    }

    private static String getWinnersName(RacingGame racingGame) {
        List<String> userNames = racingGame.getWinners()
                .stream()
                .map(Car::getCarName)
                .collect(Collectors.toList());
        return String.join(",", userNames);
    }
}
