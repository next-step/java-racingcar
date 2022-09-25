package racingcar;

public class DefaultOutput implements Output {

    public static final String RACING_RESULT_MESSAGE = "레이싱 게임 결과입니다.";

    @Override
    public void printResultMessage() {
        System.out.println(RACING_RESULT_MESSAGE);
    }

    @Override
    public void printPosition(int position) {
        for (int i = 0; i < position; i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}
