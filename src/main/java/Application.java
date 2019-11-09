import step2.dto.RacingData;
import step2.dto.ResultData;
import step2.move.RamdomMove;
import step2.racing.Racing;
import step2.view.InputView;
import step2.view.ResultView;

public class Application {
    public static void main(String[] args) {
        // input view에서는 레이싱 게임에 들어갈 차 이름을 받는 기능만 한다
        RacingData racingData = InputView.input();

        // 레이싱 게임을 생성해 주고
        Racing racing = new Racing(racingData, new RamdomMove());
        // 레이싱 게임을 진행한 데이터를 가져온다
        ResultData resultData = racing.run();

        // result view에서는
        // 레이싱 게임에서 나온 데이터들의 그래프를 그리는 기능과
        // 우승자를 알려주는 기능만 한다.
        ResultView.show(resultData, racingData.getTurn());
        // ResultView.drawGraph();
        // ResultView.announceWinner();
    }
}
