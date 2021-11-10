package racingcar.gameinfo;

import racingcar.domain.Cars;
import racingcar.domain.CarNameInfo;
import racingcar.domain.CountInfo;
import racingcar.moverule.MoveRule;
import racingcar.view.result.ResultView;

import java.util.*;

public class CarNamesInputGame implements GameInfo {

    private final List<CarNameInfo> carNames;
    private final MoveRule moveRule;
    private final CountInfo tryCount;
    private final ResultView resultView;

    public CarNamesInputGame(MoveRule moveRule, ResultView resultView, CountInfo tryCount, List<CarNameInfo> carNames){
        this.moveRule = moveRule;
        this.carNames = carNames;
        this.tryCount = tryCount;
        this.resultView = resultView;
    }

    @Override
    public MoveRule getMoveRule() {
        return this.moveRule;
    }

    @Override
    public Cars getCars() {
        return new Cars(carNames);
    }

    @Override
    public int getTryCount() {
        return this.tryCount.get();
    }

    @Override
    public ResultView getResultView() {
        return this.resultView;
    }
}