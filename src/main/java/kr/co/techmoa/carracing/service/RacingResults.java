package kr.co.techmoa.carracing.service;

import kr.co.techmoa.carracing.model.Car;
import kr.co.techmoa.carracing.model.Cars;

import java.util.List;
import java.util.stream.Collectors;

public class RacingResults {

    private List<RacingResult> results;

    public RacingResults(List<Car> cars) {
        this.results = cars
                .stream()
                .map(car -> new RacingResult(car.getCarName(), car.getPosition()))
                .collect(Collectors.toList());
    }

    public List<RacingResult> getResults() {
        return results;
    }

    public int getMaxPosition() {
        return results.stream()
                .mapToInt(RacingResult::getPosition)
                .max()
                .getAsInt();
    }

    public List<String> getWinner() {
        return results.stream()
                .filter(result -> result.getPosition() == getMaxPosition())
                .map(RacingResult::getName)
                .collect(Collectors.toList());
    }
}
