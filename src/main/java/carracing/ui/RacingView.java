package carracing.ui;

import carracing.domain.dto.RacingResult;
import carracing.domain.entity.Participant;
import carracing.domain.entity.Round;

public interface RacingView {

  Participant getNumberOfCar();

  Round getRound();

  void printResult(RacingResult result);

}
