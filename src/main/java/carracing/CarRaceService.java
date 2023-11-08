package carracing;

import carracing.dto.CarRaceRequest;
import carracing.dto.CarRaceResponse;
import carracing.dto.CarsResponse;

import java.util.ArrayList;
import java.util.List;

public class CarRaceService {
    public CarRaceResponse race(CarRaceRequest request) {
        Track track = request.toTrack();
        List<CarsResponse> carsResponses = new ArrayList<>();
        for (int i = 0; i < request.getMovingCount(); i++) {
            track.run();
            carsResponses.add(CarsResponse.from(track.carHistory()));
        }
        return new CarRaceResponse(carsResponses, track.winners());
    }
}
