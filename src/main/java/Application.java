import step2.*;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        RacingData racingData = InputView.input();

        Racing racing = new Racing(racingData, new RamdomMove());
        List<Graph> graphList = racing.run();

        ResultView resultView = new ResultView(graphList);
        resultView.show();
    }
}
