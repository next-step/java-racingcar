package racing.view;

public class InputView {

    private final String INPUT_CANDIDATES_MSG = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private final String INPUT_RETRY_COUNT_MSG = "시도할 횟수는 몇 회인가요?";

    public void printCandidates() {
        System.out.println(INPUT_CANDIDATES_MSG);
    }

    public void printRetryCount() {
        System.out.println(INPUT_RETRY_COUNT_MSG);
    }


}
