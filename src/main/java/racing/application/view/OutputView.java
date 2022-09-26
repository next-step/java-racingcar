package racing.application.view;

public class OutputView {

    private final Score score;

    public OutputView(Score score) {
        this.score = score;
    }

    public void print() {
        score.printGame();
        score.printWinner();
    }

}
