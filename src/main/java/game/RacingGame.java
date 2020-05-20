package game;

import game.ui.RacingGameInputView;
import game.ui.RacingGameResultView;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private static final int INIT_POSITION = 0;

    private final MovePolicy movePolicy;
    private final RacingGameInputView racingGameInputView;
    private final RacingGameResultView racingGameResultView;

    public RacingGame(MovePolicy movePolicy, RacingGameInputView racingGameInputView, RacingGameResultView racingGameResultView) {
        this.movePolicy = movePolicy;
        this.racingGameInputView = racingGameInputView;
        this.racingGameResultView = racingGameResultView;
    }

    public void play() {
        List<CarName> carNameList = racingGameInputView.getCarNameList();
        int time = racingGameInputView.getTime();
        List<Car> carList = new ArrayList<>();
        carNameList.forEach(carName -> carList.add(new Car(carName, INIT_POSITION, movePolicy)));

        for (int i = 0; i < time; i++) {
            racingGameResultView.printRound(i + 1);
            carList.forEach(Car::move);
            carList.forEach(racingGameResultView::printResult);
        }
    }
}
