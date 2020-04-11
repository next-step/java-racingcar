package racing.service;

import racing.domain.Cars;
import racing.domain.DefaultMovable;
import racing.domain.Movable;
import racing.service.response.RacingDTO;

public class RacingService {

    public RacingDTO playGame(String carNames, int tryCnt) {
        Cars cars = new Cars(carNames);
        Movable movable = new DefaultMovable();
        RacingDTO racingDTO = new RacingDTO(cars);

        for (int i = 0; i < tryCnt; i++) {
            cars.playRound(movable);
            racingDTO.addRoundResult(cars);
        }

        return racingDTO;
    }
}
