package racingcar.gameinfo;

import racingcar.domain.Cars;
import racingcar.domain.CountInfo;
import racingcar.moverule.MoveRule;
import racingcar.view.result.ResultView;

public class CarCountInputGame implements GameInfo {

    private final CountInfo carCount;
    private final CountInfo tryCount;
    private final MoveRule moveRule;
    private final ResultView resultView;

    public CarCountInputGame(MoveRule moveRule, ResultView resultView, CountInfo carCount, CountInfo tryCount){
        this.moveRule = moveRule;
        this.resultView = resultView;
        this.carCount = carCount;
        this.tryCount = tryCount;
    }

    @Override
    public int getTryCount() {
        return this.tryCount.get();
    }

    @Override
    public ResultView getResultView() {
        return this.resultView;
    }

    @Override
    public Cars getCars() {
        return new Cars(this.carCount.get());
    }

    @Override
    public MoveRule getMoveRule() {
        return this.moveRule;
    }
}