import step2.*;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        inputView.input();
        Racing racing = new Racing(inputView.getCarsName(), inputView.getTurn(), new RamdomMove());
//        Racing racing = new Racing(inputView.getCarsName(), inputView.getTurn());
        List<Graph> graphList = racing.run();

        ResultView resultView = new ResultView(graphList);
        resultView.show();
    }
}
