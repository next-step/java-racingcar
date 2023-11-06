package carracing.dto;

import carracing.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CarRaceResponse {
    private final List<CarsResponse> carsResponses = new ArrayList<>();
    private final List<String> winnerNames;

    public CarRaceResponse(List<CarsResponse> carsResponses, List<Car> winners) {
        this.carsResponses.addAll(carsResponses);
        this.winnerNames = winners.stream().map(Car::getName).collect(Collectors.toList());
    }

    public List<CarsResponse> getCarResponses() {
        return carsResponses;
    }
}
