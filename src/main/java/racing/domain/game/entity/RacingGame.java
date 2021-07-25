package racing.domain.game.entity;

import racing.domain.car.entity.Cars;
import racing.domain.car.vo.fuel.Fuel;
import racing.domain.game.vo.turn.Turn;
import racing.domain.game.vo.turn.Turns;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class RacingGame {
    private final Cars cars;
    private final Turns turns;
    private final Fuel fuel;

    public RacingGame(Turns turns, Cars cars, Fuel fuel) {
        this.turns = turns;
        this.cars = cars;
        this.fuel = fuel;
    }

    public boolean isEnded() {
        return turns.waitingTurns().isEmpty();
    }

    public Turns endedTurns() {
        return turns.endedTurns();
    }

    public Cars bestCars() {
        return cars.bestCars();
    }

    // 남은 경기를 모두 진행
    public void racingAll() {
        for(Turn iTurn : this.turns.waitingTurns()) {
            cars.moveAll(fuel);
            iTurn.finish(cars);
        }
    }
}
