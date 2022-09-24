package racing.application.view;

public class OutputView implements View {

    private final Score score;

    public OutputView(Score score) {
        this.score = score;
    }

    @Override
    public void print() {
        score.printGame();
        score.printWinner();
    }
}
