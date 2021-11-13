package carracing.domain.service;

import carracing.domain.dto.RacingResult;
import carracing.domain.entity.Number;
import carracing.domain.entity.Participant;
import carracing.domain.entity.Round;

public interface CarRacingService {

  void initRacing(Participant participant);

  RacingResult gameStart();
}
