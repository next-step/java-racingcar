package racing.view;

public class Output {
    private static final String START_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분.";
    private static final String COUNT_MESSAGE = "시도할 횟수는 몇회인가요?";
    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String WIN_MESSAGE = "최종 우승자: ";

    public void start() {
        System.out.println(START_MESSAGE);
    }

    public void count() {
        System.out.println(COUNT_MESSAGE);
    }

    public void result() {
        System.out.println(RESULT_MESSAGE);
    }

    public void win() {
        System.out.println(WIN_MESSAGE);
    }
}
