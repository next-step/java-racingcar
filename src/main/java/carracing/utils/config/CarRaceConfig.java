package carracing.utils.config;

import carracing.CarRaceService;
import carracing.domain.race.move.MoveStrategy;
import carracing.domain.race.move.RandomMoveStopStrategy;
import carracing.domain.race.point.RandomPointProvider;

public class CarRaceConfig {
    public static CarRaceService carRaceService() {
        return new CarRaceService(moveStrategy());
    }

    public static MoveStrategy moveStrategy() {
        return new RandomMoveStopStrategy(new RandomPointProvider());
    }
}
