package racingcar.domain;

import racingcar.dto.CarDto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RaceResult {
    private List<RoundResult> roundResults = new ArrayList<>();

    private List<String> winners;

    public void report(int round, Cars cars) {
        List<CarDto> createdCars = new ArrayList<>();
        for (Car car : cars.getCars()) {
            createdCars.add(new CarDto(car));
        }

        roundResults.add(new RoundResult(round, createdCars));
    }

    public void reportWinners(List<Car> winners) {
        this.winners = winners.stream().map(car -> car.getName().getName()).collect(Collectors.toList());
    }

    public List<RoundResult> getRoundResults() {
        return roundResults;
    }

    public List<String> getWinners() {
        return winners;
    }

    public static class RoundResult {
        private int round;
        private List<CarDto> carDtos;

        public RoundResult(int round, List<CarDto> carDtos) {
            this.round = round;
            this.carDtos = carDtos;
        }

        public int getRound() {
            return round;
        }

        public List<CarDto> getCarDtos() {
            return carDtos;
        }
    }
}
