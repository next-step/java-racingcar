package racinggame.controller;

import racinggame.domain.embeded.CarFactory;
import racinggame.dto.RaceInputDTO;
import racinggame.dto.RaceResultDTO;
import racinggame.service.RaceService;

public class RaceController {

    private RaceService raceService;

    public RaceController(RaceService raceService) {
        this.raceService = raceService;
    }

    public RaceResultDTO start(RaceInputDTO raceInputDTO) {
        return raceService.startRace(raceInputDTO, CarFactory.produce(raceInputDTO));
    }
}
