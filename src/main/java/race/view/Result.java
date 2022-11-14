package race.view;

import race.domian.Cars;

import java.util.List;
import java.util.stream.Collectors;

public final class Result {

    private static final String QUESTION_FOR_CAR_NAME = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    public static final String RESULT_SENTENCE = "실행 결과";
    public static final String QUESTION_FOR_PLAY_COUNT = "시도할 횟수는 몇 회 인가요?";
    public static final String BAR = "-";
    private static final String TEXT_FOR_WINNER = "가 최종 우승했습니다.";
    public static final String DELIMITER_FOR_WINNER = ", ";
    public static final String COLON = " : ";

    private Result() {};

    public static void getFirstQuestion() {
        System.out.println(QUESTION_FOR_CAR_NAME);
    }

    public static void getSecondQuestion() {
        System.out.println(QUESTION_FOR_PLAY_COUNT);
    }

    public static void getNewLine() {
        System.out.println();
    }

    public static void getResultSentence() {
        System.out.println(RESULT_SENTENCE);
    }

    public static void getResult(Cars cars) {
        for (int i = 0; i < cars.getPosition().size(); i++) {
            System.out.println(
                cars.getNames()
                    .get(i)
                    + COLON
                    + BAR.repeat(cars.getPosition().get(i))
            );
        }
    }

    public static void getWinner(List<String> winners) {
        System.out.println(
            winners.stream()
            .collect(Collectors.joining(DELIMITER_FOR_WINNER))
            +TEXT_FOR_WINNER
        );
    }
}
