import step2.Dao.RacingData;
import step2.Dao.ResultData;
import step2.Model.Racing;
import step2.Model.RamdomMove;
import step2.View.InputView;
import step2.View.ResultView;

public class Application {
    public static void main(String[] args) {
        RacingData racingData = InputView.input();

        Racing racing = new Racing(racingData, new RamdomMove());
        ResultData resultData = racing.run();

        ResultView.show(resultData, racingData.getTurn());
    }
}
