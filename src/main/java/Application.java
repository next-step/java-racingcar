import step2.Dao.RacingData;
import step2.Model.Graph;
import step2.Model.Racing;
import step2.Model.RamdomMove;
import step2.View.InputView;
import step2.View.ResultView;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        RacingData racingData = InputView.input();

        Racing racing = new Racing(racingData, new RamdomMove());
        List<Graph> graphList = racing.run();

        ResultView.show(graphList);
    }
}
