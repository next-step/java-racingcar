package game.domain;

import game.util.InputView;
import game.util.ResultView;

import static game.domain.Constant.ASK_CAR_COUNT_MESSAGE;
import static game.domain.Constant.ASK_GAME_COUNT_MESSAGE;
import static game.util.NumberUtil.toNaturalNumber;

public class GameInput {

    public GameInput() {}

    public int insertCarCount(){
        ResultView.printPlainMessage(ASK_CAR_COUNT_MESSAGE);
        return toNaturalNumber(InputView.insertValue());
    }

    public int insertGameCount(){
        ResultView.printPlainMessage(ASK_GAME_COUNT_MESSAGE);
        return toNaturalNumber(InputView.insertValue());
    }
}
