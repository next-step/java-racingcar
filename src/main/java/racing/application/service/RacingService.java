package racing.application.service;

import racing.application.view.Score;
import racing.domain.car.CarRace;

public interface RacingService {

    CarRace makeCars(String names);

    Score scoreBoard(CarRace carRace, int moveCount);

}
