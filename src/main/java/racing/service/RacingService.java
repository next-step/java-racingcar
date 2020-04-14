package racing.service;

import racing.domain.Cars;
import racing.domain.DefaultMovable;
import racing.domain.Movable;
import racing.service.response.RacingDto;

public class RacingService {

    public static RacingDto playGame(String[] carNames, int tryCnt) {
        Cars cars = new Cars(carNames);
        Movable movable = new DefaultMovable();
        RacingDto racingDTO = new RacingDto(cars);

        for (int i = 0; i < tryCnt; i++) {
            cars.playRound(movable);
            racingDTO.addRoundResult(cars);
        }

        return racingDTO;
    }
}
