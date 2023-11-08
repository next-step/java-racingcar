package carracing;

import carracing.domain.race.CarRace;
import carracing.ui.dto.CarRaceRequest;
import carracing.ui.dto.CarRaceResponse;
import carracing.ui.dto.CarsResponse;
import carracing.domain.race.move.MoveStrategy;

import java.util.ArrayList;
import java.util.List;

public class CarRaceService {
    private final MoveStrategy moveStrategy;

    public CarRaceService(MoveStrategy moveStrategy) {
        this.moveStrategy = moveStrategy;
    }

    public CarRaceResponse race(CarRaceRequest request) {
        CarRace carRace = request.toCarRace();

        List<CarsResponse> carsResponses = new ArrayList<>();
        for (int i = 0; i < request.getMovingCount(); i++) {
            carRace.run(moveStrategy);
            carsResponses.add(CarsResponse.from(carRace.carHistory()));
        }
        return new CarRaceResponse(carsResponses, carRace.winners());
    }
}
