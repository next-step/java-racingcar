package racingcar.view;

import java.util.List;
import java.util.stream.IntStream;

import racingcar.dto.RacingCarPrintDTO;

public class PrintView {

    private static final String INIT_RACING_CAR_PHRASE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String INIT_TRY_COUNT_PHRASE = "시도할 회수는 몇 회 인가요?";
    private static final String GAME_RESULT_MESSAGE = "실행 결과";
    private static final String RACING_CAR_POSITION_EXPRESSION = "-";
    private static final String RACING_CAR_WINNER_RESULT_MESSAGE = "가 최종 우승했습니다.";

    public static void printInitRacingCarPhrase() {
        System.out.println(INIT_RACING_CAR_PHRASE);
    }

    public static void printInitTryCountPhrase() {
        System.out.println(INIT_TRY_COUNT_PHRASE);
    }

    public static void printGameResultMessage() {
        System.out.println(GAME_RESULT_MESSAGE);
    }

    public static void printRacingCarPrintRecords(List<RacingCarPrintDTO> racingCarPrintDTOS) {
        for (RacingCarPrintDTO racingCarPrintDTO : racingCarPrintDTOS) {
            System.out.print(racingCarPrintDTO.getRacingCarName() + " : ");
            IntStream.range(0, racingCarPrintDTO.getPosition()).mapToObj(i -> RACING_CAR_POSITION_EXPRESSION).forEach(System.out::print);
            System.out.println();
        }
        System.out.println();
    }

    public static void printRacingCarWinnerResult(List<String> names) {
        System.out.println(String.join(", ", names) + RACING_CAR_WINNER_RESULT_MESSAGE);
    }
}
