package racing.service;

import racing.domain.Cars;
import racing.domain.MovableStrategy;

public interface RacingGameService {

    Cars prepare();

    void racing(Cars cars, MovableStrategy movableStrategy);
}
