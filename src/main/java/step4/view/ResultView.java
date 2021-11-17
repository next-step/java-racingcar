package step4.view;

public class ResultView {
    public static final ResultView INSTANCE = new ResultView();
    public static final String ASK_CAR_NAME = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    public static final String ASK_TRIAL_COUNT = "시도할 회수는 몇회인가요?";

    private ResultView() {}

    public static ResultView getInstance() {
        return INSTANCE;
    }

    public void sysout(String text) {
        System.out.println(text);
    }

}
