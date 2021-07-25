package racing.view;

import racing.domain.car.entity.Cars;
import racing.domain.car.vo.fuel.Fuel;
import racing.domain.game.entity.RacingGame;
import racing.domain.game.vo.turn.Turns;

public class FakeInputView implements InputView {
    private Turns turns;
    private Cars cars;
    private Fuel fuel;

    public FakeInputView(Turns turns, Cars cars, Fuel fuel) {
        this.turns = turns;
        this.cars = cars;
        this.fuel = fuel;
    }

    @Override
    public RacingGame inputRacingGame() {
        return new RacingGame(turns, cars, fuel);
    }
}