import step2.dto.RacingData;
import step2.dto.ResultData;
import step2.move.RandomMove;
import step2.racing.Racing;
import step2.view.InputView;
import step2.view.ResultView;

public class Application {
    public static void main(String[] args) {
        RacingData racingData = InputView.input();

        Racing racing = new Racing(racingData, new RandomMove());
        ResultData resultData = racing.run();

        ResultView.drawGraph(resultData, racingData.getTurn());
        ResultView.announceWinner(resultData);
    }
}
