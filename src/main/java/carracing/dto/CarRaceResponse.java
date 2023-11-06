package carracing.dto;

import java.util.ArrayList;
import java.util.List;

public class CarRaceResponse {
    private final List<CarsResponse> carsResponses = new ArrayList<>();

    public CarRaceResponse(List<CarsResponse> carsResponses) {
        this.carsResponses.addAll(carsResponses);
    }

    public List<CarsResponse> getCarResponses() {
        return carsResponses;
    }
}
