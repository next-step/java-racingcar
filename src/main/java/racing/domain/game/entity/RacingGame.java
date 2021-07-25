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
        validate(turns, cars, fuel);

        this.turns = turns;
        this.cars = cars;
        this.fuel = fuel;
    }

    private void validate(Turns turns, Cars cars, Fuel fuel) {
        if (Objects.isNull(turns) || turns.isEmpty())
            throw new IllegalArgumentException("대기중인 턴이 없습니다.");
        if (Objects.isNull(cars) || cars.isEmpty())
            throw new IllegalArgumentException("경기를 진행할 차가 없습니다.");
        if (Objects.isNull(fuel))
            throw new IllegalArgumentException("경기를 진행할 연료가 없습니다.");
    }

    // 남은 경기를 모두 진행
    public void racingAll() {
        for(Turn iTurn : this.turns.waitingTurns()) {
            cars.moveAll(fuel);
            iTurn.finish(cars);
        }
    }

    public boolean isEnded() {
        return turns.waitingTurns().isEmpty();
    }

    // Forward 메서드들
    public Turns endedTurns() {
        return turns.endedTurns();
    }

    public Cars bestCars() {
        return cars.bestCars();
    }
}
