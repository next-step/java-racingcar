package carracing.domain.service;

import carracing.domain.dto.RacingResult;
import carracing.domain.entity.Challengers;
import carracing.domain.entity.Participant;
import carracing.domain.entity.Round;

public interface CarRacingService {

  Challengers registerRacer(Participant participant);

  RacingResult gameStart(Round round, Challengers challengers);
}
