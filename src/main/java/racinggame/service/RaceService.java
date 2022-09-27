package racinggame.service;

import racinggame.domain.Car;
import racinggame.dto.RaceInputDTO;
import racinggame.dto.RaceResultDTO;

import java.util.Comparator;
import java.util.List;

import static java.util.stream.Collectors.groupingBy;

public class RaceService {

    public RaceResultDTO startRace(RaceInputDTO raceInputDTO, List<Car> cars) {

        RaceResultDTO raceResultDTO = new RaceResultDTO();

        for (int i = 0; i < raceInputDTO.roundCount(); i++) {
            moveCar(cars);
            raceResultDTO.addCarMoveResult(cars);
        }

        raceResultDTO.addWinners(winCars(cars));
        return raceResultDTO;
    }

    public List<Car> winCars(List<Car> allCars) {
        return allCars.stream()
                .collect(groupingBy(Car::distance))
                .entrySet().stream()
                .max(Comparator.comparing(entry -> Integer.valueOf(entry.getKey())))
                .get()
                .getValue();
    }

    private void moveCar(List<Car> cars) {
        cars.forEach(Car::move);
    }
}

