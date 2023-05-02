package racing.controller;

import racing.dto.RaceRequestDto;
import racing.dto.RaceResponseDto;
import racing.model.Car;
import racing.model.Cars;
import racing.model.move.MoveStrategy;
import racing.model.move.RandomMoveStrategy;

import java.util.ArrayList;
import java.util.List;

public class RaceGame {

    public RaceResponseDto startRacing(RaceRequestDto raceRequestDto) {
        List<Cars> allRoundResults = getAllRoundResults(raceRequestDto, new RandomMoveStrategy());
        Cars carsOfLastRound  = allRoundResults.get(allRoundResults.size() -1);
        List<Car> winners = findWinners(carsOfLastRound);

        return new RaceResponseDto(allRoundResults, winners);
    }

    public List<Cars> getAllRoundResults(RaceRequestDto raceRequestDto, MoveStrategy moveStrategy) {
        Cars cars = new Cars(raceRequestDto.getCarNames());
        List<Cars> results = new ArrayList<>();
        int attempts = raceRequestDto.getAttempts();

        for (int i = 0; i < attempts; i++) {
            results.add(cars.move(moveStrategy));
        }

        return results;
    }

    private List<Car> findWinners(Cars cars) {
        return cars.findWinners();
    }

}
