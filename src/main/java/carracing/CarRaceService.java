package carracing;

import carracing.domain.race.Race;
import carracing.domain.race.move.MoveStrategy;
import carracing.ui.dto.CarRaceRequest;
import carracing.ui.dto.CarRaceResponse;
import carracing.ui.dto.CarsResponse;

import java.util.ArrayList;
import java.util.List;

public class CarRaceService {
    private final MoveStrategy moveStrategy;

    public CarRaceService(MoveStrategy moveStrategy) {
        this.moveStrategy = moveStrategy;
    }

    public CarRaceResponse race(CarRaceRequest request) {
        Race race = request.toCarRace();

        List<CarsResponse> carsResponses = new ArrayList<>();
        for (int i = 0; i < request.getMovingCount(); i++) {
            race.run(moveStrategy);
            carsResponses.add(CarsResponse.from(race.carHistory()));
        }
        return new CarRaceResponse(carsResponses, race.winners());
    }
}
