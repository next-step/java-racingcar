package carracing.utils.config;

import carracing.CarRaceService;
import carracing.domain.race.move.MoveStrategy;
import carracing.domain.race.move.RandomMoveStopStrategy;
import carracing.domain.race.point.RandomPointProvider;

public class CarRaceConfig {
    private CarRaceService carRaceService;

    public CarRaceConfig() {
        this.carRaceService = this.carRaceService();
    }

    private CarRaceService carRaceService() {
        return new CarRaceService(moveStrategy());
    }

    private MoveStrategy moveStrategy() {
        return new RandomMoveStopStrategy(new RandomPointProvider());
    }

    public CarRaceService getCarRaceService() {
        return carRaceService;
    }
}
