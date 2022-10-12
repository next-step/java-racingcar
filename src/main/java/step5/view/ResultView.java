package step5.view;

import java.util.Iterator;
import java.util.List;
import step5.domain.RacingResult;

public class ResultView {

    private static final String CAR_NAME_NOTICE_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)";
    private static final String TRY_COUNT_NOTICE_MESSAGE = "시도할 회수는 몇 회인가요?";
    private static final String CAR_POSITION_INDEX = "-";
    private static final String RESULT_NOTICE_MESSAGE = "실행 결과";
    private static final String WINNER_NOTICE_MESSAGE = "가 최종 우승했습니다.";

    public static void printCarNames(){
        System.out.println(CAR_NAME_NOTICE_MESSAGE);
    }

    public static void printTryCount() {
        System.out.println(TRY_COUNT_NOTICE_MESSAGE);
    }

    public static void printRacingResults(List<RacingResult> racingResults, int carCount) {
        Iterator<RacingResult> racingResultIterator = racingResults.iterator();

        while (racingResultIterator.hasNext()) {
            printEachRoundResult(racingResultIterator, carCount);
            printDividingLine();
        }
    }

    private static void printEachRoundResult(Iterator<RacingResult> racingResultIterator, int carCount) {
        for (int i = 0; i < carCount; i++) {
            RacingResult result = racingResultIterator.next();
            String carName = result.getCarName();
            int location = result.getLocation();
            System.out.println(carName + " : " + CAR_POSITION_INDEX.repeat(location));
        }
    }

    public static void printStartMessage() {
        System.out.println(RESULT_NOTICE_MESSAGE);
    }

    public static void printDividingLine() {
        System.out.println();
    }

    public static void printWinner(String winners) {
        System.out.println(winners + WINNER_NOTICE_MESSAGE);
    }
}
