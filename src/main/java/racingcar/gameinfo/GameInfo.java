package racingcar.gameinfo;

import racingcar.car.Cars;
import racingcar.moverule.MoveRule;
import racingcar.moverule.RandomMoveRule;
import racingcar.view.InputView;

public class GameInfo {

    private final CountInfo countInfo;
    private final MoveRule moveRule;

    private GameInfo(CountInfo countInfo, MoveRule moveRule){
        this.moveRule = moveRule;
        this.countInfo = countInfo;
    }

    public static GameInfo randomMoveGame() {
        return new GameInfo(getCountInfo(), new RandomMoveRule());
    }

    private static CountInfo getCountInfo(){
        return InputView.getCountInfo();
    }

    public int getTryCount() {
        return this.countInfo.getTryCount();
    }

    public Cars getCars() {
        return new Cars(this.moveRule, this.countInfo.getCarCount());
    }
}