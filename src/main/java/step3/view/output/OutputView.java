package step3.view.output;

import step3.game.domain.car.Players;

public interface OutputView {

    void result();

    String carDistance(Integer distance);

    void finalResult(Players carInfo);

    void endOfThisTurn(Players cars);
}
