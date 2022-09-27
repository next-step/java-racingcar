package racinggame.service;

import racinggame.domain.Car;
import racinggame.dto.RaceInputDTO;
import racinggame.dto.RaceResultDTO;

import java.util.List;

public class RaceService {

    public RaceResultDTO startRace(RaceInputDTO raceInputDTO, List<Car> cars) {

        RaceResultDTO raceResultDTO = new RaceResultDTO();

        for (int i = 0; i < raceInputDTO.roundCount(); i++) {
            moveCar(cars);
            raceResultDTO.addCarMoveResult(cars);
        }

        return raceResultDTO;
    }

    private void moveCar(List<Car> cars) {
        cars.forEach(Car::move);
    }
}

