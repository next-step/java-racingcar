import step2.InputView;
import step2.Racing;
import step2.RamdomMove;
import step2.ResultView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        inputView.input();
        Racing racing = new Racing(inputView.getCarsName(), inputView.getTurn(), new RamdomMove());
        racing.run();
        ResultView resultView = new ResultView(racing);
        resultView.show();
    }
}
