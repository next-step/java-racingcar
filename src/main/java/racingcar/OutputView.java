package racingcar;

public class OutputView {

    private final String CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";

    private final String COUNT_MESSAGE = "시도할 회수는 몇회인가요?";

    private final String PLAY_RESULT_TITLE_MESSAGE = "\n실행 결과";

    public void print(String message) {
        System.out.println(message);
    }

    public void printCarNames() {
        print(CAR_NAMES_MESSAGE);
    }

    public void printCount() {
        print(COUNT_MESSAGE);
    }

    public void printPlayResultTitle() {
        print(PLAY_RESULT_TITLE_MESSAGE);
    }
}
