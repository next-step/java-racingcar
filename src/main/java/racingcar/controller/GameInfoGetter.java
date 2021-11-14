package racingcar.controller;

import racingcar.domain.model.CarNameInfo;
import racingcar.domain.model.CountInfo;
import racingcar.domain.gameround.CarCountGameRound;
import racingcar.domain.gameround.CarNameGameRound;
import racingcar.domain.gameinfo.CarCountInputGame;
import racingcar.domain.gameinfo.CarNamesInputGame;
import racingcar.domain.gameinfo.GameInfo;
import racingcar.domain.moverule.RandomMoveRule;
import racingcar.view.InputView;

import java.util.*;

public class GameInfoGetter {

    private GameInfoGetter() {}

    public static GameInfo carNamesGame(){
        String carNamesInput = InputView.getInput("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        List<CarNameInfo> carNames = CarNameInfo.createListFromInput(carNamesInput.split(","));
        CountInfo tryCount = new CountInfo(InputView.getIntValue("시도할 회수는 몇 회 인가요?"));
        return new CarNamesInputGame(new RandomMoveRule(), new CarNameGameRound(), tryCount, carNames);
    }

    public static GameInfo carCountGame(){
        CountInfo carCount = new CountInfo(InputView.getIntValue("자동차 대수는 몇 대 인가요?"));
        CountInfo tryCount = new CountInfo(InputView.getIntValue("시도할 회수는 몇 회 인가요?"));
        return new CarCountInputGame(new RandomMoveRule(), new CarCountGameRound(), carCount, tryCount);
    }
}