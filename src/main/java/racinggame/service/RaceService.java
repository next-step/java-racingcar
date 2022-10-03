package racinggame.service;

import racinggame.domain.RacingCars;
import racinggame.dto.RaceInputDTO;
import racinggame.dto.RaceResultDTO;
import racinggame.domain.RoundSnapshot;

public class RaceService {

    public RaceResultDTO startRace(RaceInputDTO raceInputDTO, RacingCars cars) {

        RaceResultDTO raceResultDTO = new RaceResultDTO();

        for (int i = 0; i < raceInputDTO.roundCount(); i++) {
            cars.move();
            raceResultDTO.addRoundSnapshot(new RoundSnapshot(cars));
        }

        raceResultDTO.addWinners(cars.winners());
        return raceResultDTO;
    }
}

