package racingcar;

public class ConsoleOutput {

    private static final String RACING_RESULT_MESSAGE = "레이싱 게임 결과입니다.";

    public void printResultMessage() {
        System.out.println(RACING_RESULT_MESSAGE);
    }

    public void printPosition(int position) {
        for (int i = 0; i < position; i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}
