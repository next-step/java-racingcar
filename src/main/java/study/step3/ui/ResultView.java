package study.step3.ui;

public class ResultView {

    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String CAR_MOVEMENT = "-";
    private final StringBuilder sb = new StringBuilder();

    public void printResult() {
        this.sb.append('\n').append(RESULT_MESSAGE).append('\n');
    }

    public void printCarPosition(int position) {
        this.sb.append(CAR_MOVEMENT.repeat(position)).append('\n');
    }

    public void separateGameRound() {
        this.sb.append('\n');
    }

    public void gameEnd() {
        System.out.println(this.sb.toString());
    }

}
