package racing.domain.car.entity;

import racing.domain.car.vo.fuel.Fuel;
import racing.domain.game.dto.Turn;

public interface Car {
    void move(Turn turn, Fuel fuel);
}
