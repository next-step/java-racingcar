package racingcar.game;

import racingcar.domain.CarNameInfo;
import racingcar.domain.CountInfo;
import racingcar.gameinfo.CarCountInputGame;
import racingcar.gameinfo.CarNamesInputGame;
import racingcar.gameinfo.GameInfo;
import racingcar.moverule.RandomMoveRule;
import racingcar.view.result.CarNameResultView;
import racingcar.view.input.InputView;
import racingcar.view.result.PositionResultView;

import java.util.*;

public class GameInfoGetter {

    private GameInfoGetter() {}

    public static GameInfo carNamesGame(){
        String carNamesInput = InputView.getInput("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        List<CarNameInfo> carNames = CarNameInfo.createListFromInput(carNamesInput.split(","));
        CountInfo tryCount = new CountInfo(InputView.getIntValue("시도할 회수는 몇 회 인가요?"));
        return new CarNamesInputGame(new RandomMoveRule(), new CarNameResultView(), tryCount, carNames);
    }

    public static GameInfo carCountGame(){
        CountInfo carCount = new CountInfo(InputView.getIntValue("자동차 대수는 몇 대 인가요?"));
        CountInfo tryCount = new CountInfo(InputView.getIntValue("시도할 회수는 몇 회 인가요?"));
        return new CarCountInputGame(new RandomMoveRule(), new PositionResultView(), carCount, tryCount);
    }
}