package carracing.ui;

import carracing.domain.dto.RacingResult;
import carracing.domain.entity.Round;

public interface RacingView {

  Round getRound();

  void printResult(RacingResult result);

}
