package CarRacing.domain;

import CarRacing.Utils.StringUtils;

import java.util.List;
import java.util.Scanner;

public class RacingApplication {
    static final private Scanner INPUT_SCANNER = new Scanner(System.in);
    static final private String FIRST_SENTENCE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    static final private String SECOND_SENTENCE = "시도할 회수는 몇 회 인가요?";
    static final private String RESULT_SENTENCE = "실행 결과";
    static final private String WINNER_SENCTENCE = " 가 최종 우승했습니다.";

    final private RacingGame racingGame;

    public RacingApplication() {
        this.racingGame = new RacingGame(StringUtils.splitStringToStringArr(getCarName()), getRacingTime());
        System.out.println(RESULT_SENTENCE);
        this.racingGame.raceStart();
        showLastWinner();
    }

    private String getCarName() {
        System.out.println(FIRST_SENTENCE);
        return INPUT_SCANNER.next();
    }

    private int getRacingTime() {
        System.out.println(SECOND_SENTENCE);
        return INPUT_SCANNER.nextInt();
    }

    private void showLastWinner() {
        final StringBuilder sb = new StringBuilder();
        final List<String> winnerList = this.racingGame.getRacingWinner();
        sb.append(String.join(",", winnerList)).append(WINNER_SENCTENCE);

        System.out.println(sb.toString());
    }
}
