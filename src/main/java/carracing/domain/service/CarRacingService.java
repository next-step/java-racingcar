package carracing.domain.service;

import carracing.domain.dto.RacingResult;
import carracing.domain.entity.Number;
import carracing.domain.entity.Round;

import java.util.function.Supplier;

public interface CarRacingService {

  void initRacing(Number number, Round round);

  RacingResult gameStart();

  Supplier<Boolean> isMoved();
}
