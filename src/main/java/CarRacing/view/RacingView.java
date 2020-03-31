package CarRacing.view;

import CarRacing.Utils.StringUtils;
import CarRacing.domain.Car;
import CarRacing.domain.RacingCars;
import CarRacing.domain.RacingGame;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class RacingView {
    static final private Scanner INPUT_SCANNER = new Scanner(System.in);
    static final private String FIRST_SENTENCE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    static final private String SECOND_SENTENCE = "시도할 회수는 몇 회 인가요?";
    static final private String RESULT_SENTENCE = "실행 결과";
    static final private String WINNER_SENCTENCE = " 가 최종 우승했습니다.";
    static private final String BAR = "-";
    static private final String LINE_BREAK = "\n";
    static private final String COLON =" : ";

    public RacingView() {
        final RacingGame racingGame = new RacingGame(
                Arrays.stream(StringUtils.splitStringToStringArr(RacingView.getCarName()))
                        .map(Car::new)
                        .collect(Collectors.toList()), RacingView.getRacingTime());
        System.out.println(RESULT_SENTENCE);
        racingGame.raceStart();
        RacingView.showLastWinner(racingGame);
    }

    public static String getCarName() {
        System.out.println(FIRST_SENTENCE);
        return INPUT_SCANNER.next();
    }

    public static int getRacingTime() {
        System.out.println(SECOND_SENTENCE);
        return INPUT_SCANNER.nextInt();
    }

    public static void showLastWinner(final RacingGame racingGame) {
        final StringBuilder sb = new StringBuilder();
        final List<String> winnerList = racingGame.getRacingWinner();
        sb.append(String.join(",", winnerList)).append(WINNER_SENCTENCE);

        System.out.println(sb.toString());
    }

    public static String makeGauge(final int count) {
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(BAR);
        }

        sb.append(LINE_BREAK);
        return sb.toString();
    }

    public static void makeCarsCurrentStatusToString(final RacingCars racingCars) {
        final StringBuilder sb = new StringBuilder();
        for (Car car : racingCars.getRacingCars()) {
            sb.append(car.getName())
                    .append(COLON)
                    .append(makeGauge(car.getCurrentPosition()));
        }

        System.out.println(sb.toString());
    }
}
