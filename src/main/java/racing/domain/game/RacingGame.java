package racing.domain.game;

import racing.domain.car.entity.Cars;
import racing.domain.car.vo.fuel.Fuel;
import racing.domain.game.dto.Turn;
import racing.domain.game.dto.Turns;

import java.util.Objects;

public class RacingGame {
    private final Cars cars;
    private final Turns turns;

    public RacingGame(Cars cars, Turns turns) {
        validate(turns, cars);

        this.turns = turns;
        this.cars = cars;
    }

    private void validate(Turns turns, Cars cars) {
        if (Objects.isNull(cars) || cars.isEmpty())
            throw new IllegalArgumentException("경기를 진행할 차가 없습니다.");
        if (Objects.isNull(turns))
            throw new IllegalArgumentException("대기중인 턴이 없습니다.");
    }

    public Turns racingAll(Fuel fuel) {
        for (Turn iTurn : turns) {
            cars.moveAll(iTurn, fuel);
        }
        return turns;
    }
}
