package carracing.domain.service;

import carracing.domain.dto.RacingResult;
import carracing.domain.entity.Cars;
import carracing.domain.entity.Participant;
import carracing.domain.entity.Round;

public interface CarRacingService {

  Cars registerRacer(Participant participant);

  RacingResult gameStart(Round round, Cars cars);
}
